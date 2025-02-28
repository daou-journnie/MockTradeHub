package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.mocktradehub.model.Post;

import java.util.List;

public class PostDAO {

    public PostDAO() {}

    // 포스트 INSERT
    public int insertPost(SqlSession session, Post post) {
        int result = 0;
        try {
            result = session.insert("PostMapper.insertPost", post);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 특정 방의 포스트 리스트 조회
    public List<Post> getPostsByRoomId(SqlSession session, int roomId) {
        List<Post> posts = null;
        try {
            posts =  session.selectList("PostMapper.getPostsByRoomId", roomId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
}
