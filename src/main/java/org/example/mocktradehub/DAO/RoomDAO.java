package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.model.RoomMember;

import java.util.Date;
import java.util.List;

public class RoomDAO {

    public RoomDAO() {}


    // 방 생성
    public int insertRoom(SqlSession session, Room room) {
       return session.insert("RoomMapper.insertRoom", room);
    }

    // 멤버별 방 조회
    public List<RoomMember> getMyRooms(SqlSession session, String member_id) {
        System.out.println("RoomDAO.getMyRooms meber_id= "+member_id);
        List<RoomMember> roomMembers =  session.selectList("RoomMapper.getMyRooms", member_id);
        System.out.println(roomMembers);
        return roomMembers;
    }

    public Date getEndDateById(SqlSession session, int roomId) {
        Room room = session.selectOne("RoomMapper.getEndDateById", roomId);
        return room.getRoomEndDate();
    }
}
