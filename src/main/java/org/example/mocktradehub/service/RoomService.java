package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.RoomDAO;
import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.util.MyBatisSessionFactory;

import java.util.Date;

public class RoomService {
    private RoomDAO roomDAO;

    public RoomService() {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.roomDAO = new RoomDAO(factory);
    }

    public boolean createRoom(Room room) {
        // 방 상태 자동 설정 (비즈니스 로직)
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

        int result = roomDAO.insertRoom(room);
        return result > 0;
    }
}
