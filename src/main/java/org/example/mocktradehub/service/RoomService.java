package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.RoomDAO;
import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.util.CodeGenerator;
import org.example.mocktradehub.util.MyBatisSessionFactory;

import java.util.Date;
import java.util.List;

public class RoomService {
    private SqlSessionFactory sqlSessionFactory;
    private RoomDAO roomDAO;

    public RoomService() {
        this.sqlSessionFactory = MyBatisSessionFactory.getSqlSessionFactory();
        this.roomDAO = new RoomDAO();
    }

    public int createRoom(Room room) {
        // 방 상태 자동 설정 (ACTIVE, INACTIVE, CLOSED)
        String roomStatus = "ACTIVE"; // 기본값
        Date now = new Date();
        Date start = room.getRoomStartDate();
        Date end = room.getRoomEndDate();


        if (start != null && now.before(start)) {
            roomStatus = "INACTIVE";
        } else if (start != null && end != null && now.after(end)) {
            roomStatus = "CLOSED";
        } else if (start != null && end != null && now.after(start) && now.before(end)) {
            roomStatus = "ACTIVE";
        }
        room.setRoomStatus(roomStatus);

        // 방 코드 생성
        room.setRoomCode(CodeGenerator.generateRoomCode(8));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            int roomId = roomDAO.insertRoom(sqlSession, room);
            if (roomId > 0) {
                sqlSession.commit();
                return roomId;
            }
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return -1;
    }


    public List<RoomMember> getMyRooms(String member_id) {
        System.out.println("service getMyRooms");
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        List<RoomMember> rooms = null;
        try {
            System.out.println("service getMyRooms try");
            rooms = this.roomDAO.getMyRooms(sqlSession, member_id);
            if (rooms != null) {
                return rooms;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return rooms;


    }
}
