package org.example.mocktradehub.controller.room;

import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.model.Portfolio;
import org.example.mocktradehub.model.RoomMember;
import org.example.mocktradehub.service.OrderService;
import org.example.mocktradehub.service.RoomMemberService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/room/roomProfit")
public class RoomProfitController extends HttpServlet {
    OrderService orderService = new OrderService();
    RoomMemberService roomMemberService = new RoomMemberService();
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String roomId = request.getParameter("roomId");

        List<RoomMember> roomMembers = this.roomMemberService.getAllRoomMembers(Integer.parseInt(roomId));
        List<JSONObject> jsonList = new ArrayList<>();
        for (RoomMember roomMember : roomMembers) {
            System.out.println("memberId: " + roomMember.getMemberId());
            System.out.println("memberNickname: " + roomMember.getMemberNickname());
            int roomMemberId = roomMember.getRoomMemberId();

            // transactionHistory.jsp에 넘길 값
            // roomTransactionBalance.jsp
            int balance = roomMember.getRoomMemberBalance();
            System.out.println("\n balance : " + balance +"\n");
            // 주문 서비스를 통해 해당 방 멤버의 평가금(주식 투자 평가금)을 조회 (DAO를 통해 계산된 값)
            int totalEvaluationValue = orderService.getTotalEvaluation(roomMemberId);
            System.out.println("total evaluation value : " + totalEvaluationValue);
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
            JSONObject jsonData = new JSONObject();
            jsonData.put("memberId", roomMember.getMemberId());
            jsonData.put("memberNickname", roomMember.getMemberNickname());
            jsonData.put("totalProfitRate", totalProfitRate);
            jsonData.put("totalAsset", totalAsset);
            System.out.println(jsonData);

            jsonList.add(jsonData);
        }
        System.out.println(jsonList);

        // 수익율 순으로 정렬
        jsonList.sort((o1, o2) -> Integer.compare(o2.getInt("totalAsset"), o1.getInt("totalAsset")));

        System.out.println("여기까지 오니");
        JSONArray jsonArray = new JSONArray(jsonList);
        System.out.println(jsonArray.toString());
        response.getWriter().write(jsonArray.toString());

    }

}
