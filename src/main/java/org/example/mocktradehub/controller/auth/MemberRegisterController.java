package org.example.mocktradehub.controller.auth;

import org.example.mocktradehub.model.Member;
import org.example.mocktradehub.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class MemberRegisterController extends HttpServlet {
    private MemberService memberService = new MemberService();

    // 회원가입 폼 보여주기
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    // 회원가입 처리
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        // 폼 파라미터 가져오기
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");

        // Member 모델 생성
                Member member = new Member();
                member.setMemberId(id);
                member.setMemberPassword(password);
                member.setMemberName(name);
                member.setMemberNickname(nickname);
                // memberCreatedAt는 DB에서 SYSTIMESTAMP로 처리되므로 별도 설정 불필요
        // memberIsActive는 기본값 1로 설정됨

        // 회원가입 처리

        // 회원가입 처리 (에러 메시지를 반환)
        String error = memberService.register(member);

        if(error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }
}
