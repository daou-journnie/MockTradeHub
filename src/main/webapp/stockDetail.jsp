<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= request.getAttribute("stockTitle") %> 상세 정보</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <script>
        var approvalKey = "<%= request.getAttribute("approvalKey") %>";
        var stockCode = "<%= request.getAttribute("stockId") %>"
    </script>
    <script src="../js/websocketDetail.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/stockDetail.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
<%
    String stockId = (String) request.getAttribute("stockId");
    String stockTitle = (String) request.getAttribute("stockTitle");
    String price = (String) request.getAttribute("price");
    String prdy = (String) request.getAttribute("prdy");
    int roomId = (int) request.getAttribute("roomId");
%>
    <div id="stockInfo">
        <h3><%= stockTitle + "(" + stockId + ")"%></h3>
        <span class="price" id=<%= "price-" + stockId%>><%= price %></span>
        <span id=<%= "prdy-" + stockId%>><%= prdy %></span>
    </div>
    <div id="buy-section">
        <form>
            <h4>주문하기</h4>
            <label>수량</label>
            <input id="buyingAmount" type="number" name="buyingAmount" value="0" min="0"/>
            <hr>
            <div class="totalPrice">
                <span class="left-text">구매가능 금액</span>
                <span class="right-text">0원</span>
            </div>
            <div class="totalPrice">
                <span class="left-text">예상 총 주문 금액</span>
                <span class="right-text" id="expectedTotal">최대 0원</span>
            </div>
            <input name="realPrice" type="hidden" id="realPrice" value="<%= price %>"/>
            <input name="roomId" type="hidden" id="roomId" value="<%= roomId %>"/>
            <button id="buyBtn">매수</button>
            <button id="sellBtn">매도</button>
        </form>
    </div>
</body>
</html>
