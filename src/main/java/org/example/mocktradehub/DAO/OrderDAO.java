package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.model.Portfolio;
import org.example.mocktradehub.model.Stock;

import java.util.List;

public class OrderDAO {
    public OrderDAO() {
    }

    public int insertOrder(SqlSession session, Order order) {
        int result = 0;
        System.out.println("DAO : " + order.getStockCode());
        try {
            result = session.insert("OrderMapper.insertOrder", order);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Order selectOrderById(SqlSession session, int id) {
        Order order = null;
        try {
            order = session.selectOne("OrderMapper.selectOrderByIdToPost", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    public int countTotalQuantity(SqlSession session, Order order) {
        int total = 0;

        try {
            total = session.selectOne("OrderMapper.countTotalQuantityByRoomMemberIdAndStockCode", order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }

    public int sumTotalPrice(SqlSession session, Order order) {
        int total = 0;

        try {
            total = session.selectOne("OrderMapper.sumTotalPriceByRoomMemberIdAndStockCode", order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }


    public List<Stock> getStocksListByRoomMemberId(SqlSession session, int roomMemberId) {
        List<Stock> stocksList = null;
        try {
            stocksList = session.selectList("StockMapper.selectStocksByRoomMemberId");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stocksList;
    }

    public int getTotalEvaluationByRoomMemberId(SqlSession session, int roomMemberId) {
        int totalEvaluation = 0;
        try {
            totalEvaluation = session.selectOne("OrderMapper.getTotalEvaluationByRoomMemberId", roomMemberId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalEvaluation;
    }

    public List<Order> selectOrdersByRoomMemberId(SqlSession session, int roomMemberId) {
        List<Order> orders = null;
        try {
            orders = session.selectList("OrderMapper.selectOrdersByRoomMemberId", roomMemberId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Portfolio> selectPortfoliosByRoomMemberId(SqlSession session, int roomMemberId) {
        List<Portfolio> portfolios = null;
        try {
            portfolios = session.selectList("OrderMapper.selectPortfoliosByRoomMemberId", roomMemberId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return portfolios;

    }
}
