package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.RoomDAO;
import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.util.CodeGenerator;
import org.example.mocktradehub.util.MyBatisSessionFactory;

import java.util.Date;

public class RoomService {
    private RoomDAO roomDAO;

    public RoomService() {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.roomDAO = new RoomDAO(factory);
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

        // return 값을 생성된 방 아이디로 하고 싶음 있어보셈...
        int new_room_id = roomDAO.insertRoom(room);

        if(new_room_id > 0) {
            return room.getRoomId();
        }
        return -1;  // 실패 시 음수나 예외 처리
    }
}
