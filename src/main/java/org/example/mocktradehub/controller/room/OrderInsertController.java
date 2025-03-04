package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.service.OrderService;
import org.example.mocktradehub.service.RoomMemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/room/order")
public class OrderInsertController extends HttpServlet {
    private OrderService orderService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("id");
        int roomId = Integer.parseInt(request.getParameter("roomId"));

        RoomMember roomMember = new RoomMember();
        roomMember.setRoomId(roomId);
        roomMember.setMemberId(memberId);

        RoomMemberService rmService = new RoomMemberService();

        int roomMemberId = rmService.getRoomMemberId(roomMember);
        String orderType = request.getParameter("orderType"); // "BUY" 또는 "SELL"
        int orderTotalQuantity = Integer.parseInt(request.getParameter("buyingAmount"));
        int orderPrice = Integer.parseInt(request.getParameter("realPrice"));
        String stockCode = request.getParameter("stockCode");

        // Order 객체 생성
        Order order = new Order();
        order.setRoomMemberId(roomMemberId);
        order.setOrderType(orderType);
        order.setOrderTotalQuantity(orderTotalQuantity);
        order.setOrderPrice(orderPrice);
        order.setStockCode(stockCode);
        order.setRoomID(roomId);
        System.out.println("OrderInsertController : " + order.getStockCode());
        String message;
        try {
            message = orderService.createOrder(memberId, order);
        } catch (Exception e) {
            e.printStackTrace();
            message = "failure";
        }

        // JSON 응답 작성
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String jsonResponse = "{\"success\": \"" + message + "\"}";
        response.getWriter().write(jsonResponse);
    }
}
