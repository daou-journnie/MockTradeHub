package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.PostDAO;
import org.example.mocktradehub.DAO.StockDAO;
import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.model.Post;
import org.example.mocktradehub.util.MyBatisSessionFactory;

import java.util.List;

public class PostService {
    private SqlSessionFactory factory;
    private PostDAO postDAO;
    private StockDAO stockDAO;


    public PostService() {
        this.factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.postDAO = new PostDAO();
        this.stockDAO = new StockDAO();
    }

    // 포스트 작성 처리: 성공 시 true 반환
    public boolean createPost(Post post) {
        SqlSession session = factory.openSession();

        int result = postDAO.insertPost(session, post);
        return result > 0;
    }

    public boolean createOrderPost(Order order) {
        SqlSession session = factory.openSession();

        Post post = new Post();
        String stockName = stockDAO.getStockNameByCode(session, order.getStockCode());
        // 주문 정보를 기반으로 포스트 내용을 생성
        String orderTypeKorean = order.getOrderType().equalsIgnoreCase("BUY") ? "구매" : "판매";

        String postContent = String.format("{%s} {%d}주 {%s}\n1주당 {%s}원",
                stockName,
                order.getOrderTotalQuantity(),
                orderTypeKorean,
                order.getOrderPrice());

        post.setPostContent(postContent);
        post.setMemberId(order.getRoomMemberId());
        post.setRoomId(order.getRoomID());
        int result = postDAO.insertPost(session, post);
        return result > 0;
    }


    // 특정 방의 포스트 리스트 조회
    public List<Post> getPostsByRoomId(int roomId) {
        SqlSession session = factory.openSession();
        return postDAO.getPostsByRoomId(session, roomId);
    }
}
