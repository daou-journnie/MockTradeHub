package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Post;
import org.example.mocktradehub.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/room/dashboard")
public class RoomDashboardController extends HttpServlet {
    private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("room dashboard doGet");

        // roomId를 파라미터로 받음
        String roomIdStr = request.getParameter("roomId");
        if (roomIdStr == null || roomIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid roomId");
            return;
        }
        int roomId = Integer.parseInt(roomIdStr);

        // PostService를 통해 해당 방의 포스트 리스트 조회
        List<Post> postList = postService.getPostsByRoomId(roomId);
        request.setAttribute("posts", postList);
        request.setAttribute("roomId", roomId);

        // roomDashboardView.jsp로 포워딩
        request.getRequestDispatcher("/roomDashboardView.jsp").forward(request, response);
    }

}
