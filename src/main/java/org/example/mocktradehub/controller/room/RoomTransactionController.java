package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Portfolio;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.service.RoomMemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/room/transactionHistory")
public class RoomTransactionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String roomId = request.getParameter("roomId");
        String memberId = (String) session.getAttribute("id");

        RoomMember roomMember = new RoomMember();
        roomMember.setRoomId(Integer.parseInt(roomId));
        roomMember.setMemberId(memberId);

        RoomMemberService roomMemberService = new RoomMemberService();
        int roomMemberId = roomMemberService.getRoomMemberId(roomMember);

        List<Portfolio> portfolioList = orderService.getPortfolioList(roomMemberId);




        request.setAttribute("roomId", roomId);

        RequestDispatcher rd = request.getRequestDispatcher("../roomMockTrade.jsp");
        rd.forward(request, response);
    }
}
