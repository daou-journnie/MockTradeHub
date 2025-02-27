package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.Order;

public class OrderDAO {
    private SqlSessionFactory sqlSessionFactory;

    public OrderDAO(SqlSessionFactory factory) {
        this.sqlSessionFactory = factory;
    }

    public int insertOrder(Order order) {
        SqlSession session = sqlSessionFactory.openSession();
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

    public Order selectOrderById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
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
}
