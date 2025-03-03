package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.RoomMemberDAO;
import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.util.MyBatisSessionFactory;
import org.omg.CORBA.UserException;

import java.util.List;

public class RoomMemberService {

    private RoomMemberDAO roomMemberDAO;
    private SqlSessionFactory factory;
    public RoomMemberService() {
        this.factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.roomMemberDAO = new RoomMemberDAO();
    }

    public RoomMember getRoomMember(RoomMember roomMember) {
        SqlSession session = factory.openSession();
        RoomMember currRoomMember = roomMemberDAO.selectRoomMemberByMemberIdAndRoomId(session, roomMember);
        session.close();
        return currRoomMember;
    }

    public List<RoomMember> getAllRoomMembers(int roomId) {
        SqlSession session = factory.openSession();
        List<RoomMember> roomMembers = roomMemberDAO.selectRoomMembersByRoomId(session, roomId);
        session.close();
        return roomMembers;
    }

    public int getBalance(RoomMember roomMember) {
        SqlSession session = factory.openSession();
        int balance = roomMemberDAO.getBalanceByMemberIdAndRoomId(session, roomMember);
        session.close();
        return balance;
    }


    public int getRoomMemberId(RoomMember roomMember) {
        SqlSession session = factory.openSession();
        int roomMemberId = roomMemberDAO.getRoomMemberId(session, roomMember);
        session.close();
        return roomMemberId;
    
    }

    public int createRoomMember(int roomId, String memberId, int initialBalance) {
        SqlSession session = factory.openSession(false);

        RoomMember roomMember = new RoomMember();
        roomMember.setRoomId(roomId);
        roomMember.setMemberId(memberId);
        roomMember.setRoomMemberBalance(initialBalance);

        try {
            int roomMemberId = roomMemberDAO.insertRoomMember(session, roomMember);
            if (roomMemberId > 0) {
                session.commit();
                return roomMemberId;
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return -1;

    }
}
