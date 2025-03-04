package org.example.mocktradehub.controller.room;

import okhttp3.*;
import org.example.mocktradehub.service.StockService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@WebServlet("/room/stockChart")
public class RoomStockChartController extends HttpServlet {

    private String approvalKey;

//    @Override
//    public void init() throws ServletException {
//
//        String appKey;
//        String secretKey;
//
//        Properties properties = new Properties();
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream("stockKey.properties")) {
//            if (input == null) {
//                throw new ServletException("stockkey.properties 파일을 찾을 수 없습니다.");
//            }
//            properties.load(input);
//            appKey = properties.getProperty("stock.appkey");
//            secretKey = properties.getProperty("stock.secretkey");
//        } catch (IOException e) {
//            throw new ServletException("파일 로드 중 오류 발생", e);
//        }
//
//        OkHttpClient client = new OkHttpClient();
//
//        // 요청할 JSON 데이터 (예: 사용자 등록)
//        String json = String.format(
//                "{ \"grant_type\": \"client_credentials\", \"appkey\": \"%s\", \"secretkey\": \"%s\" }",
//                appKey, secretKey
//        );
//
//        // JSON 데이터 타입 설정
//        MediaType JSON = MediaType.get("application/json; charset=utf-8");
//
//        // 요청 본문 설정
//        RequestBody body = RequestBody.create(json, JSON);
//
//        Request request = new Request.Builder()
//                .url("https://openapi.koreainvestment.com:9443/oauth2/Approval")
//                .post(body)
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            System.out.println("응답 코드: " + response.code());
//            approvalKey = response.body().string().substring(17, 53);
//            System.out.println(approvalKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        StockService stockService = new StockService();
        Map<String, Integer> stockPrice = stockService.getStockClosingPrice();

        request.setAttribute("roomId", roomId);
        request.setAttribute("approvalKey", "9824f828-57e8-458f-b996-48fe5fb04bb8");
        request.setAttribute("stockPrice", stockPrice);
        RequestDispatcher rd = request.getRequestDispatcher("../roomMockTrade.jsp");
        rd.forward(request, response);
    }
}
