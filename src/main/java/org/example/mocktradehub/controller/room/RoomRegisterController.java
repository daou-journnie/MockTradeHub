package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.service.RoomMemberService;
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
    private RoomMemberService roomMemberService = new RoomMemberService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/roomRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        String memberId = null;
        if (session != null) {
            memberId = (String) session.getAttribute("id");
        }

        // 로그인되지 않은 사용자는 글 작성 불가
        if (memberId == null) {
            String contextPath = request.getContextPath();
            response.getWriter().println("<script>alert('로그인이 필요합니다.'); location.href='" + contextPath +"/login.jsp';</script>");
            return;
        }

        // 요청 파라미터 읽기
        String roomName = request.getParameter("roomName");
        int roomIsPublic = Integer.parseInt(request.getParameter("roomIsPublic"));
        int roomMaxMembers = Integer.parseInt(request.getParameter("roomMaxMembers"));
        String roomStartDateStr = request.getParameter("roomStartDate");
        String roomEndDateStr = request.getParameter("roomEndDate");
        int roomInitialSeed = Integer.parseInt(request.getParameter("roomInitialSeed")+"0000");
        String roomDescription = request.getParameter("roomDescription");
        String roomCreatedBy = memberId;

        System.out.println("roomName: " + roomName);
        System.out.println("roomIsPublic: " + roomIsPublic);
        System.out.println("roomMaxMembers: " + roomMaxMembers);
        System.out.println("roomStartDate: " + roomStartDateStr);
        System.out.println("roomEndDate: " + roomEndDateStr);
        System.out.println("roomInitialSeed: " + roomInitialSeed);
        System.out.println("roomDescription: " + roomDescription);
        System.out.println("roomCreatedBy: " + roomCreatedBy);


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
        room.setRoomDescription(roomDescription);
        room.setRoomCreatedBy(roomCreatedBy);

        // 서비스 호출: RoomService가 방 상태를 계산하고, 방을 생성함
        int roomId = roomService.createRoom(room);
        boolean isCreated = roomId > 0;

        if (isCreated) {
            this.roomMemberService.createRoomMember(roomId, memberId, roomInitialSeed);
            // 생성된 방의 상세 페이지로 이동: 예시 URL: /room/dashboard?roomId=XXX
            response.sendRedirect(request.getContextPath() + "roomDashboard.jsp?roomId=" + roomId);
        } else {
            request.setAttribute("error", "방 생성에 실패했습니다.");
            request.getRequestDispatcher("/roomRegister").forward(request, response);
        }

    }
}
