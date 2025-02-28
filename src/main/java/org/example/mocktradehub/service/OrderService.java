package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.OrderDAO;
import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.util.MyBatisSessionFactory;

public class OrderService {
    private SqlSessionFactory factory;
    private OrderDAO orderDAO;
    private PostService postService;

    public OrderService() {
        this.factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.orderDAO = new OrderDAO();
    }

    public String createOrder(Order order) {
        SqlSession session = factory.openSession();

        String orderType = order.getOrderType();
        String message;
        int result;

        if (orderType.equals("BUY")) {

        } else if (orderType.equals("SELL")) {
            int quantityHeld = orderDAO.countTotalQuantity(session, order);
            if (quantityHeld < order.getOrderTotalQuantity()) {
                System.out.println();
            }
        } else {
            message = "잘못된 입력입니다";
            return message;
        }

        int id = orderDAO.insertOrder(session, order);

        order.setOrderId(id);
        if(id > 0) {
            // order to post 처리
            postService.createOrderPost(order);
            message = "거래가 완료되었습니다.";
            return message;
        } else {
            message = "거래에 실패했습니다";
            return message;
        }

    }

    public Order getOrderByOrderId(int orderId) {
        SqlSession session = factory.openSession();
        return orderDAO.selectOrderById(session, orderId);
    }

}
