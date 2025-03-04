package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Post;
import org.example.mocktradehub.service.MemberService;
import org.example.mocktradehub.service.PostService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/room/post/insert")
public class PostInsertController extends HttpServlet {
    private PostService postService = new PostService();
    private MemberService memberService = new MemberService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 한글 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // roomId 파라미터 검증
        String roomIdStr = request.getParameter("roomId");
        if (roomIdStr == null || roomIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid roomId");
            return;
        }
        int roomId = Integer.parseInt(roomIdStr);

        // 폼 파라미터 읽기
        String postContent = request.getParameter("postContent");
        String parentIdStr = request.getParameter("postParentId");
        Integer postParentId = (parentIdStr != null && !parentIdStr.isEmpty())
                ? Integer.parseInt(parentIdStr) : 0;
        String memberId = request.getParameter("memberId");
        System.out.println("memberId: " + memberId);
        String memberNickname = memberService.getMemberById(memberId).getMemberNickname();

        // Post 객체 생성 및 값 설정
        Post post = new Post();
        post.setPostContent(postContent);
        post.setPostParentId(postParentId);
        post.setRoomId(roomId);
        post.setMemberId(memberId);
        post.setMemberNickname(memberNickname);




        // 서비스 호출: 포스트 INSERT
        boolean isCreated = postService.createPost(post);
        if (isCreated) {
            // JSON 응답 생성 (RoomDashboardController와 유사한 형식)
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("postId", post.getPostId());
            jsonResponse.put("memberId", post.getMemberId());
            jsonResponse.put("memberNickname", post.getMemberNickname());
            jsonResponse.put("postContent", post.getPostContent());
            jsonResponse.put("postComments", post.getComments()); // post.getComments()가 JSONArray 또는 List라면 적절히 변환됨
            jsonResponse.put("createdAt", post.getPostCreatedAt());
            System.out.println("post insert controller:  "+post.getPostCreatedAt());



            response.getWriter().write(jsonResponse.toString());
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "포스트 작성에 실패했습니다.");
        }
    }
}
