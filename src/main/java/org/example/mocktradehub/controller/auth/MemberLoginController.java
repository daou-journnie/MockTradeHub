package org.example.mocktradehub.controller.auth;

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

        boolean isLoggedIn = memberService.login(id, password);

        if(isLoggedIn) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("roomId", "1");
            response.sendRedirect("roomDashboard.jsp");
//            response.sendRedirect(request.getContextPath() + "/room/dashboard?roomId=6");
        } else {
            request.setAttribute("error", "로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}
