package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.service.OrderService;
import org.example.mocktradehub.service.RoomMemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/room/stockDetail")
public class RoomStockDetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String stockCode = req.getParameter("stockCode");
        String stockTitle = req.getParameter("stockTitle");
        String price = req.getParameter("price");
        String prdy = req.getParameter("prdy");
        String approvalKey = req.getParameter("approvalKey");
        int roomId = Integer.parseInt(req.getParameter("roomId"));

        HttpSession session = req.getSession();
        String memberId = (String) session.getAttribute("id");
        RoomMemberService roomMemberService = new RoomMemberService();
        RoomMember roomMember = new RoomMember();
        roomMember.setRoomId(roomId);
        roomMember.setMemberId(memberId);

        // 잔액 조회
        int balance = roomMemberService.getBalance(roomMember);

        // 보유 수량 조회
        int roomMemberId = roomMemberService.getRoomMemberId(roomMember);
        OrderService orderService = new OrderService();
        int quantity = orderService.countQuantityHeld(roomMemberId, stockCode);
        System.out.println("controller quantity: " + quantity);

        req.setAttribute("stockCode", stockCode);
        req.setAttribute("stockTitle", stockTitle);
        req.setAttribute("price", price);
        req.setAttribute("prdy", prdy);
        req.setAttribute("approvalKey", approvalKey);
        req.setAttribute("roomId", roomId);
        req.setAttribute("balance", balance);
        req.setAttribute("quantity", quantity);

        RequestDispatcher rd = req.getRequestDispatcher("../roomMockTradeDetail.jsp");
        rd.forward(req, resp);
    }
}
