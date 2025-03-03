package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Member;
import org.example.mocktradehub.model.Room;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.service.RoomService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/room/myRooms")
public class RoomListController extends HttpServlet {
    private RoomService roomService = new RoomService();
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // 요청 파라미터에서 `member_id` 가져오기
        String member_id = req.getParameter("member_id");

        if (member_id == null || member_id.isEmpty()) {
            resp.getWriter().write("[]"); // member_id 없으면 빈 배열 반환
            return;
        }
        System.out.println("member_id: " + member_id);

        // 해당 멤버의 방 목록 조회
        List<RoomMember> rooms = this.roomService.getMyRooms(member_id);


        // JSON 변환 후 응답
        JSONArray jsonArray = new JSONArray();
        for (RoomMember room : rooms) {
            JSONObject jsonRoom = new JSONObject();
            jsonRoom.put("roomId", room.getRoomId());
            jsonRoom.put("roomCode", room.getRoomCode());
            jsonRoom.put("roomName", room.getRoomName());
            jsonRoom.put("roomDescription", room.getRoomDescription());
            jsonRoom.put("roomIsPublic", room.getRoomIsPublic());
            jsonRoom.put("roomMemberBalance", room.getRoomMemberBalance());

            jsonArray.put(jsonRoom);
        }

        resp.getWriter().write(jsonArray.toString());
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
