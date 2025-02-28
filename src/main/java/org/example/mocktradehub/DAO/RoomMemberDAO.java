package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.RoomMember;

import java.util.List;

public class RoomMemberDAO {
    private SqlSessionFactory sqlSessionFactory;


    public RoomMemberDAO(SqlSessionFactory factory) {
        this.sqlSessionFactory = factory;
    }

    public int getBalance(RoomMember roomMember) {
        SqlSession session = sqlSessionFactory.openSession();
        int balance = 0;

        try {
            balance = session.selectOne("RoomMemberMapper.selectBalanceByMemberIdAndRoomId", roomMember);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return balance;
    }

    public int getRoomMemberId(RoomMember roomMember) {
        SqlSession session = sqlSessionFactory.openSession();
        int roomMemberId = 0;

        try {
            roomMemberId = session.selectOne("RoomMemberMapper.selectRoomMemberIdByMemberIdAndRoomId", roomMember);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return roomMemberId;
    }
}
