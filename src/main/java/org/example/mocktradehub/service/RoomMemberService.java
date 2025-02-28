package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.RoomMemberDAO;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.util.MyBatisSessionFactory;

public class RoomMemberService {

    private RoomMemberDAO roomMemberDAO;
    private SqlSessionFactory factory;
    public RoomMemberService() {
        this.factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.roomMemberDAO = new RoomMemberDAO();
    }

    public int getBalance(RoomMember roomMember) {
        SqlSession session = factory.openSession();
        int balance = roomMemberDAO.getBalanceByMemberIdAndRoomId(session, roomMember);
        session.close();
        return balance;
    }

    public int getBalance(int roomMemberId) {
        SqlSession session = factory.openSession();
        int balance = roomMemberDAO.getBalanceByRoomMemberId(session, roomMemberId);
        session.close();
        return balance;
    }

    public int getRoomMemberId(RoomMember roomMember) {
        SqlSession session = factory.openSession();
        int roomMemberId = roomMemberDAO.getRoomMemberId(session, roomMember);
        session.close();
        return roomMemberId;
    
    }
}
