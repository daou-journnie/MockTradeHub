package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.OrderDAO;
import org.example.mocktradehub.DAO.StockDAO;
import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.model.Post;
import org.example.mocktradehub.model.Stock;
import org.example.mocktradehub.util.MyBatisSessionFactory;

public class OrderService {
    private OrderDAO orderDAO;
    private PostService postService;

    public OrderService() {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.orderDAO = new OrderDAO(factory);
    }

    // 주문 생성 (insert) 후 성공 시 true 반환
    public boolean createOrder(Order order) {
        int id = orderDAO.insertOrder(order);

        if(id > 0) {
            // order to post 처리
            postService.createOrderPost(getOrderByOrderId(id));

            // post insert



            return true;
        } else {
            // 실패 시 null 또는 예외 처리를 할 수 있습니다.
            return false;
        }

    }

    public Order getOrderByOrderId(int orderId) {
        return orderDAO.selectOrderById(orderId);
    }
}
