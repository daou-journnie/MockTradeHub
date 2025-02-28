package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.PostDAO;
import org.example.mocktradehub.DAO.StockDAO;
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

    // 특정 방의 포스트 리스트 조회
    public List<Post> getPostsByRoomId(int roomId) {
        SqlSession session = factory.openSession();
        return postDAO.getPostsByRoomId(session, roomId);
    }
}
