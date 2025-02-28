package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSessionFactory;

import org.example.mocktradehub.DAO.RoomMemberDAO;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.util.MyBatisSessionFactory;

public class RoomMemberService {
    private RoomMemberDAO roomMemberDAO;

    public RoomMemberService() {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.roomMemberDAO = new RoomMemberDAO(factory);
    }

    public int getBalance(RoomMember roomMember) {
        return roomMemberDAO.getBalance(roomMember);
    }

    public int getRoomMemberId(RoomMember roomMember) {
        return roomMemberDAO.getRoomMemberId(roomMember);
    }
}
