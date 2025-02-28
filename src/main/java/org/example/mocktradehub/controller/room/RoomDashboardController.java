package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Post;
import org.example.mocktradehub.service.PostService;
import org.json.JSONArray;
import org.json.JSONObject;

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

        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 요청 파라미터에서 `member_id` 가져오기
        int roomId = Integer.parseInt(request.getParameter("roomId"));

//        if (roomId == null || roomId.isEmpty()) {
//            response.getWriter().write("[]"); // member_id 없으면 빈 배열 반환
//            return;
//        }
        System.out.println("memberId: " + roomId);

        // 해당 멤버의 방 목록 조회
        List<Post> postList = this.postService.getPostsByRoomId(roomId);


        //  JSON 변환 후 응답
        JSONArray jsonArray = new JSONArray();
        for (Post post : postList) {
            JSONObject jsonPost = new JSONObject();
            jsonPost.put("postId", post.getPostId());
            jsonPost.put("memberId", post.getMemberId());
            jsonPost.put("memberNickname", post.getMemberNickname());
            jsonPost.put("postContent", post.getPostContent());
            jsonPost.put("postComments", post.getComments());
            jsonPost.put("createdAt", post.getPostCreatedAt());
            jsonArray.put(jsonPost);
        }

        response.getWriter().write(jsonArray.toString());
    }

}
