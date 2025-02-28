package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.mocktradehub.model.RoomMember;

public class RoomMemberDAO {
    private SqlSession sqlSession;

    public RoomMemberDAO() {}

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertRoomMember(RoomMember roomMember) {
        return this.sqlSession.insert("RoomMemberMapper.insertRoomMember", roomMember);
    }
}
