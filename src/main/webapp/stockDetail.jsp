<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title><%= request.getAttribute("stockTitle") %> 상세 정보</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <script>
        <%--var approvalKey = "<%= request.getAttribute("approvalKey") %>";--%>
        var stockCode = "<%= request.getAttribute("stockCode") %>";
        var highestPrice = <%= (int) request.getAttribute("price")%>;
    </script>
    <script src="../js/websocketDetail.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stockDetail.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
<%
    String stockCode = (String) request.getAttribute("stockCode");
    String stockTitle = (String) request.getAttribute("stockTitle");
    int price = (int) request.getAttribute("price");
    String priceText = (String) request.getAttribute("priceText");
    String prdy = (String) request.getAttribute("prdy");
    int roomId = (int) request.getAttribute("roomId");
    int balance = (int) request.getAttribute("balance");
    int quantity = (int) request.getAttribute("quantity");
    System.out.println("jsp quantity: " + quantity);
    DecimalFormat df = new DecimalFormat("#,###");
    String formattedBalance = df.format(balance);
    String formattedQuantity = df.format(quantity);
%>

    <div id="buy-section">
        <div id="stockInfo">
            <h3><%= stockTitle + "(" + stockCode + ")"%></h3>
            <span class="price" id=<%= "price-" + stockCode%>><%= priceText %></span>
            <span id=<%= "prdy-" + stockCode%>><%= prdy %></span>
        </div>
        <hr>
        <form>
            <h4>주문하기</h4>
            <label>수량</label>
            <input id="buyingAmount" type="number" name="buyingAmount" value="0" min="0"/>
            <hr>
            <div class="totalPrice">
                <span class="left-text">구매 가능 금액</span>
                <span id="totalBalance" class="right-text"><%= formattedBalance %>원</span>
            </div>
            <div class="totalPrice">
                <span class="left-text">보유 수량</span>
                <span id="totalStocks" class="right-text"><%= formattedQuantity %>주</span>
            </div>
            <hr>
            <div class="totalPrice">
                <span class="left-text">예상 거래 금액</span>
                <span class="right-text" id="expectedTotal">최대 0원</span>
            </div>
            <input name="realPrice" type="hidden" id="realPrice" value="<%= price %>"/>
            <input name="roomId" type="hidden" id="roomId" value="<%= roomId %>"/>
            <div class="button-container">
                <button id="buyBtn">매수</button>
                <button id="sellBtn">매도</button>
            </div>
        </form>
    </div>
