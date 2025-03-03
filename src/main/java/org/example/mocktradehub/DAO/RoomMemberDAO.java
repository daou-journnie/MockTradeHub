package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.mocktradehub.model.RoomMember;

import java.util.List;

public class RoomMemberDAO {
    private SqlSession session;


    public RoomMemberDAO() {

    }

    public RoomMember selectRoomMemberByMemberIdAndRoomId(SqlSession session, RoomMember roomMember) {
        RoomMember currRoomMember = null;

        try {
            currRoomMember = session.selectOne("RoomMemberMapper.selectRoomMemberByMemberIdAndRoomId", roomMember);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currRoomMember;
    }

    public List<RoomMember> selectRoomMembersByRoomId(SqlSession session, int roomId) {
        List<RoomMember> roomMembers = null;
        try {
            roomMembers = session.selectList("RoomMemberMapper.selectRoomMembersByRoomId", roomId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomMembers;
    }



    public int getBalanceByMemberIdAndRoomId(SqlSession session, RoomMember roomMember) {
        int balance = 0;

        try {
            balance = session.selectOne("RoomMemberMapper.selectBalanceByMemberIdAndRoomId", roomMember);
            System.out.println("dao balance: " + balance);
            System.out.println("dao roomId: " + roomMember.getRoomId());
            System.out.println("dao memberId: " + roomMember.getMemberId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return balance;
    }

    public int getBalanceByRoomMemberId(SqlSession session, int roomMemberId) {
        int balance = 0;

        try {
            balance = session.selectOne("RoomMemberMapper.selectBalanceByRoomMemberId", roomMemberId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return balance;
    }

    public int getRoomMemberId(SqlSession session, RoomMember roomMember) {
        int roomMemberId = 0;

        try {
            roomMemberId = session.selectOne("RoomMemberMapper.selectRoomMemberIdByMemberIdAndRoomId", roomMember);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roomMemberId;
    }

    public int updateBalance(SqlSession session, RoomMember roomMember) {
        int result = 0;

        try {
            result = session.update("RoomMemberMapper.updateBalanceByRoomMemberId", roomMember);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int insertRoomMember(SqlSession session, RoomMember roomMember) {
        int result = 0;

        try {
            result = session.insert("RoomMemberMapper.insertRoomMember", roomMember);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
