package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.Order;

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
}
