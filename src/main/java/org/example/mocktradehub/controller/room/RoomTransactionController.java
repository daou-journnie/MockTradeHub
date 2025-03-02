package org.example.mocktradehub.controller.room;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.model.Portfolio;
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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@WebServlet("/room/transactionHistory")
public class RoomTransactionController extends HttpServlet {
    OrderService orderService = new OrderService();
    RoomMemberService roomMemberService = new RoomMemberService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String roomId = request.getParameter("roomId");
        String memberId = (String) session.getAttribute("id");

        RoomMember roomMember = new RoomMember();
        roomMember.setRoomId(Integer.parseInt(roomId));
        roomMember.setMemberId(memberId);
        roomMember = roomMemberService.getRoomMember(roomMember);
        int roomMemberId = roomMember.getRoomMemberId();

        // transactionHistory.jsp에 넘길 값
        // roomTransactionBalance.jsp
        int balance = roomMember.getRoomMemberBalance();
        System.out.println("\n balance : " + balance +"\n");
        // 주문 서비스를 통해 해당 방 멤버의 평가금(주식 투자 평가금)을 조회 (DAO를 통해 계산된 값)
        int totalEvaluationValue = orderService.getTotalEvaluation(roomMemberId);
        // 총 자산 = 잔액 + 평가금
        int totalAsset = balance + totalEvaluationValue;
        // 초기 시드 값
        int seed = roomMember.getRoomInitialSeed();
        // 총 수익률 계산
        BigDecimal totalProfitRate = BigDecimal.ZERO;
        if (seed != 0) {
            BigDecimal bdTotalAsset = new BigDecimal(totalAsset);
            BigDecimal bdSeed = new BigDecimal(seed);
            totalProfitRate = bdTotalAsset.subtract(bdSeed)
                    .multiply(new BigDecimal(100))
                    .divide(bdSeed, 2, RoundingMode.HALF_UP);
        }

        // roomTransactionHistory.jsp
        List<Order> orderList = orderService.getOrderList(roomMemberId);
        System.out.println("order list : "+ orderList);
        // roomTransactionInvestment.jsp
        List<Portfolio> portfolioList = orderService.getPortfolioList(roomMemberId);

        request.setAttribute("balance", balance);
        request.setAttribute("totalAsset", totalAsset);
        request.setAttribute("totalProfitRate", totalProfitRate);
        request.setAttribute("orderList", orderList);
        request.setAttribute("portfolioList", portfolioList);

        request.getRequestDispatcher("/transactionHistory.jsp").forward(request, response);
    }
}
