package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.Post;

import java.util.List;

public class PostDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PostDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // 포스트 INSERT
    public int insertPost(Post post) {
        SqlSession session = sqlSessionFactory.openSession();
        int result = 0;
        try {
            result = session.insert("PostMapper.insertPost", post);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    // 특정 방의 포스트 리스트 조회
    public List<Post> getPostsByRoomId(int roomId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("PostMapper.getPostsByRoomId", roomId);
        } finally {
            session.close();
        }
    }
}
