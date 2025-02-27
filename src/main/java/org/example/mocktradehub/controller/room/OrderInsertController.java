package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/room/*/order")
public class OrderInsertController extends HttpServlet {
    private OrderService orderService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // URL에서 roomId 추출
        String roomIdStr = extractRoomId(request);
        if (roomIdStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid roomId");
            return;
        }
        int roomId = Integer.parseInt(roomIdStr);

        // 주문 정보 파라미터 읽기
        String roomMemberId = request.getParameter("roomMemberId");
        String orderType = request.getParameter("orderType"); // "BUY" 또는 "SELL"
        int orderTotalQuantity = Integer.parseInt(request.getParameter("orderTotalQuantity"));
        int orderPrice = Integer.parseInt(request.getParameter("orderPrice"));
        String stockCode = request.getParameter("stockCode");

        // Order 객체 생성
        Order order = new Order();
        order.setRoomMemberId(roomMemberId);
        order.setOrderType(orderType);
        order.setOrderTotalQuantity(orderTotalQuantity);
        order.setOrderPrice(orderPrice);
        order.setStockCode(stockCode);
        order.setRoomID(roomId);
        // order_time은 DB 기본값으로 처리됨

        boolean isCreated = orderService.createOrder(order);

        // JSON 응답 작성
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String jsonResponse = "{\"success\": " + (isCreated ? "true" : "false") + "}";
        response.getWriter().write(jsonResponse);
    }

    // URL에서 /room/{roomId}/order 형식에서 roomId 추출
    private String extractRoomId(HttpServletRequest request) {
        String uri = request.getRequestURI(); // 예: /YourContext/room/123/order
        String contextPath = request.getContextPath(); // 예: /YourContext
        String path = uri.substring(contextPath.length()); // /room/123/order
        int startIndex = path.indexOf("/room/") + 6; // position after "/room/"
        int endIndex = path.lastIndexOf("/order");
        if (startIndex < 6 || endIndex <= startIndex) {
            return null;
        }
        return path.substring(startIndex, endIndex);
    }
}
