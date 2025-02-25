package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/room/register")
public class RoomRegisterController extends HttpServlet {
    private RoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/roomRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 요청 파라미터 읽기
        String roomName = request.getParameter("roomName");
        int roomIsPublic = Integer.parseInt(request.getParameter("roomIsPublic"));
        int roomMaxMembers = Integer.parseInt(request.getParameter("roomMaxMembers"));
        String roomStartDateStr = request.getParameter("roomStartDate");
        String roomEndDateStr = request.getParameter("roomEndDate");
        int roomInitialSeed = Integer.parseInt(request.getParameter("roomInitialSeed"));
        String roomCode = request.getParameter("roomCode");
        String roomDescription = request.getParameter("roomDescription");
        String roomCreatedBy = request.getParameter("roomCreatedBy");

        // 날짜 파싱 (yyyy-MM-dd 형식)
        Date roomStartDate = null;
        Date roomEndDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (roomStartDateStr != null && !roomStartDateStr.isEmpty()) {
                roomStartDate = sdf.parse(roomStartDateStr);
            }
            if (roomEndDateStr != null && !roomEndDateStr.isEmpty()) {
                roomEndDate = sdf.parse(roomEndDateStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Room 객체 생성 (방 상태는 아직 설정하지 않음)
        Room room = new Room();
        room.setRoomName(roomName);
        room.setRoomIsPublic(roomIsPublic);
        room.setRoomMaxMembers(roomMaxMembers);
        room.setRoomStartDate(roomStartDate);
        room.setRoomEndDate(roomEndDate);
        room.setRoomInitialSeed(roomInitialSeed);
        room.setRoomCode(roomCode);
        room.setRoomDescription(roomDescription);
        room.setRoomCreatedBy(roomCreatedBy);

        // 서비스 호출: RoomService가 방 상태를 계산하고, 방을 생성함
        boolean isCreated = roomService.createRoom(room);
        if (isCreated) {
            response.sendRedirect("roomList.jsp");
        } else {
            request.setAttribute("error", "방 생성에 실패했습니다.");
            request.getRequestDispatcher("/roomRegister.jsp").forward(request, response);
        }
    }
}
