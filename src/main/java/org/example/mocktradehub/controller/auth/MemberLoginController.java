package org.example.mocktradehub.controller.auth;

import org.example.mocktradehub.model.Member;
import org.example.mocktradehub.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class MemberLoginController extends HttpServlet {
    MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Member isLoggedInMember = memberService.login(id, password);

        if(isLoggedInMember != null) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("nickname", isLoggedInMember.getMemberNickname());
            response.sendRedirect(request.getContextPath() +"/mainDashboard.jsp");

        } else {
            request.setAttribute("error", "로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}
