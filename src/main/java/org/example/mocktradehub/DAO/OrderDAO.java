package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.Order;

public class OrderDAO {
    private SqlSession session;

    public OrderDAO() {
    }

    public int insertOrder(SqlSession session, Order order) {
        int result = 0;
        try {
            result = session.insert("OrderMapper.insertOrder", order);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public Order selectOrderById(SqlSession session, int id) {
        Order order = null;
        try {
            order = session.selectOne("OrderMapper.selectOrderByIdToPost", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }

    public int countTotalQuantity(SqlSession session, Order order) {
        int total = 0;

        try {
            total = session.selectOne("OrderMapper.countTotalQuantityByRoomMemberIdAndStockId", order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return total;
    }
}
