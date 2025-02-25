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
        boolean isRegistered = memberService.register(member);
        if (isRegistered) {
            // 회원가입 성공: 로그인 페이지로 리다이렉트
            response.sendRedirect("login.jsp");
        } else {
            // 회원가입 실패: 중복된 아이디 등의 사유로 실패
            request.setAttribute("error", "회원가입 실패! 중복된 아이디이거나 등록 오류가 발생했습니다.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
