package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.model.RoomMember;

import java.util.List;

public class RoomDAO {
    private SqlSession sqlSession;


    public RoomDAO() {}


    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // 방 생성
    public int insertRoom(Room room) {
       return this.sqlSession.insert("RoomMapper.insertRoom", room);
    }

    // 멤버별 방 조회
    public List<RoomMember> getMyRooms(String member_id) {
        System.out.println("RoomDAO.getMyRooms meber_id= "+member_id);
        List<RoomMember> roomMembers =  this.sqlSession.selectList("RoomMapper.getMyRooms", member_id);
        System.out.println(roomMembers);
        return roomMembers;
    }
}
