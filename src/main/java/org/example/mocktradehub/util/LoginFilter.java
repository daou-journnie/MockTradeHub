package org.example.mocktradehub.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // HttpServletRequest로 변환
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 세션 확인
        HttpSession session = httpRequest.getSession(false); // 기존 세션을 가져옴 (없으면 null)

        // 세션에 "user" 속성이 없다면 로그인 페이지로 리디렉션
        if (session == null || session.getAttribute("id") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp"); // 로그인 페이지로 리디렉션
        } else {
            // 로그인 되어 있으면 필터 체인을 이어서 실행
            chain.doFilter(request, response);
        }
    }

}
