package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.OrderDAO;
import org.example.mocktradehub.DAO.PostDAO;
import org.example.mocktradehub.DAO.RoomMemberDAO;
import org.example.mocktradehub.DAO.StockDAO;
import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.model.Portfolio;
import org.example.mocktradehub.model.Post;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.util.MyBatisSessionFactory;

import java.util.List;

public class OrderService {
    private SqlSessionFactory factory;
    private OrderDAO orderDAO;
    private PostService postService;

    public OrderService() {
        this.factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.orderDAO = new OrderDAO();
    }

    public int countQuantityHeld(int roomMemberId, String stockCode) {
        int quantity = 0;
        SqlSession session = factory.openSession();

        Order order = new Order();
        order.setRoomMemberId(roomMemberId);
        order.setStockCode(stockCode);

        quantity = orderDAO.countTotalQuantity(session, order);
        return quantity;
    }

    public String createOrder(String memberId, Order order) {
        SqlSession session = factory.openSession(false);
        String orderType = order.getOrderType();
        String message = validateOrder(session, order, orderType);

        if (message != null) {
            session.close();
            return message;
        }

        // 거래 테이블 insert
        System.out.println("Service : " + order.getStockCode());
        int orderResult = orderDAO.insertOrder(session, order);

        // 잔액 update
        int balanceResult = updateBalance(session, order, orderType);

        // Post 테이블 insert
        String postContent = createPostContent(session, order, orderType);
        int postResult = insertPost(session, memberId, order, postContent);

        // Commit or rollback
        if (orderResult > 0 && balanceResult > 0 && postResult > 0) {
            session.commit();
            message = "거래에 성공했습니다.";
        } else {
            session.rollback();
            message = "거래에 실패했습니다.";
        }

        session.close();
        return message;
    }

    private String validateOrder(SqlSession session, Order order, String orderType) {
        RoomMemberDAO roomMemberDAO = new RoomMemberDAO();
        if (order.getOrderPrice() <= 0) {
            return "수량을 입력하세요";
        }

        int balance = roomMemberDAO.getBalanceByRoomMemberId(session, order.getRoomMemberId());
        int quantityHeld = orderDAO.countTotalQuantity(session, order);

        if (orderType.equals("BUY")) {
            if (balance < order.getOrderTotalQuantity() * order.getOrderPrice()) {
                return "보유 잔액이 부족합니다.";
            }
        } else if (orderType.equals("SELL")) {
            if (quantityHeld < order.getOrderTotalQuantity()) {
                return "보유 수량이 부족합니다.";
            }
        } else {
            return "잘못된 입력입니다.";
        }

        return null;
    }

    private int updateBalance(SqlSession session, Order order, String orderType) {
        RoomMemberDAO roomMemberDAO = new RoomMemberDAO();
        int balance = roomMemberDAO.getBalanceByRoomMemberId(session, order.getRoomMemberId());
        RoomMember roomMember = new RoomMember();
        roomMember.setRoomMemberId(order.getRoomMemberId());

        if (orderType.equals("BUY")) {
            balance -= order.getOrderPrice() * order.getOrderTotalQuantity();
        } else if (orderType.equals("SELL")) {
            balance += order.getOrderPrice() * order.getOrderTotalQuantity();
        }

        roomMember.setRoomMemberBalance(balance);
        return roomMemberDAO.updateBalance(session, roomMember);
    }

    private String createPostContent(SqlSession session, Order order, String orderType) {
        StockDAO stockDAO = new StockDAO();
        String stockName = stockDAO.getStockNameByCode(session, order.getStockCode());
        String orderTypeKorean = orderType.equals("BUY") ? "구매" : "판매";
        return String.format("%s %d주 %s\n1주당 %,d원", stockName, order.getOrderTotalQuantity(), orderTypeKorean, order.getOrderPrice());
    }

    private int insertPost(SqlSession session, String memberId, Order order, String postContent) {
        PostDAO postDAO = new PostDAO();
        Post post = new Post();
        post.setPostContent(postContent);
        post.setMemberId(memberId);
        post.setRoomId(order.getRoomID());
        return postDAO.insertPost(session, post);
    }

    public Order getOrderByOrderId(int orderId) {
        SqlSession session = factory.openSession();
        return orderDAO.selectOrderById(session, orderId);
    }


    // 총 평가액(보유 주식 평가금) 조회 서비스 메서드
    public int getTotalEvaluation(int roomMemberId) {
        SqlSession session = factory.openSession();
        int totalEvaluation = 0;
        try {
            totalEvaluation = orderDAO.getTotalEvaluationByRoomMemberId(session, roomMemberId);
        } finally {
            session.close();
        }
        return totalEvaluation;
    }

    public List<Order> getOrderList(int roomMemberId) {
        SqlSession session = factory.openSession();
        List<Order> orders = null;
        // 보유주식 리스트 받아오기
        orders = orderDAO.selectOrdersByRoomMemberId(session, roomMemberId);
        return orders;
    }

    public List<Portfolio> getPortfolioList(int roomMemberId) {
        SqlSession session = factory.openSession();
        List<Portfolio> portfolios = null;
        // 보유주식 리스트 받아오기
        portfolios = orderDAO.selectPortfoliosByRoomMemberId(session, roomMemberId);
        return portfolios;
    }





}
