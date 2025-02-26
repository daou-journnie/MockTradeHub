package org.example.mocktradehub.controller.room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/room/dashboard")
public class RoomDashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // roomDashboardView.jsp로 포워딩
        request.getRequestDispatcher("/roomDashboardView.jsp").forward(request, response);
    }
}
