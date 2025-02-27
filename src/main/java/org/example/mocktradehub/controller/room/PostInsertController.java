package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Member;
import org.example.mocktradehub.model.Post;
import org.example.mocktradehub.service.MemberService;
import org.example.mocktradehub.service.PostService;

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
        request.setCharacterEncoding("UTF-8");
        // roomId를 파라미터로 받음
        String roomIdStr = request.getParameter("roomId");
        if (roomIdStr == null || roomIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid roomId");
            return;
        }
        int roomId = Integer.parseInt(roomIdStr);

        // 요청 파라미터 읽기
        String postContent = request.getParameter("postContent");
        String parentIdStr = request.getParameter("postParentId");
        Integer postParentId = (parentIdStr != null && !parentIdStr.isEmpty())
                ? Integer.parseInt(parentIdStr) : null;
        String memberId = request.getParameter("memberId");
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
            request.setAttribute("message", "포스트 작성 성공!");
//            request.setAttribute("roomId", roomId);
            response.sendRedirect(request.getContextPath() + "/room/dashboard?roomId="+roomId);

        } else {
            request.setAttribute("error", "포스트 작성에 실패했습니다.");
        }

    }

}
