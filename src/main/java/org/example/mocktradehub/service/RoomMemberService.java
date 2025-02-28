package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.RoomDAO;
import org.example.mocktradehub.DAO.RoomMemberDAO;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.util.MyBatisSessionFactory;

public class RoomMemberService {
    private SqlSessionFactory sqlSessionFactory;
    private RoomMemberDAO roomMemberDAO;

    public RoomMemberService() {
        this.sqlSessionFactory = MyBatisSessionFactory.getSqlSessionFactory();
        this.roomMemberDAO = new RoomMemberDAO();
    }

    public int createRoomMember(int roomId, String memberId, int initialBalance) {
        RoomMember roomMember = new RoomMember(roomId, memberId, initialBalance);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        this.roomMemberDAO.setSqlSession(sqlSession);

        try {
            int roomMemberId = this.roomMemberDAO.insertRoomMember(roomMember);
            if (roomMemberId > 0) {
                sqlSession.commit();
                return roomMemberId;
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return -1;

    }
}
