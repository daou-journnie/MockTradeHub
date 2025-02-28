package org.example.mocktradehub.controller.room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/room/stockDetail")
public class RoomStockDetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String stockId = req.getParameter("stockId");
        String stockTitle = req.getParameter("stockTitle");
        String price = req.getParameter("price");
        String prdy = req.getParameter("prdy");
        String approvalKey = req.getParameter("approvalKey");
        String roomId = req.getParameter("roomId");

        req.setAttribute("stockId", stockId);
        req.setAttribute("stockTitle", stockTitle);
        req.setAttribute("price", price);
        req.setAttribute("prdy", prdy);
        req.setAttribute("approvalKey", approvalKey);
        req.setAttribute("roomId", roomId);

        RequestDispatcher rd = req.getRequestDispatcher("../stockDetail.jsp");
        rd.forward(req, resp);
    }
}
