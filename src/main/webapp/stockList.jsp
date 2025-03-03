<%@ page contentType="text/html; charset=UTF-8" %>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>실시간 주식 가격</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
<script>
    var approvalKey = "<%= request.getAttribute("approvalKey") %>";
    var roomId = "<%= request.getAttribute("roomId") %>";
</script>
<script src="../js/websocket.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stocklist.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">

<div id="table-section">
    <div id="tableTitle">
        <h1>실시간 차트</h1>
    </div>
    <div id="stockTable">
        <table>
            <tr>
                <th class="stockTitle">종목명</th>
                <th>현재가</th>
                <th>전날 대비 등락</th>
                <th>누적 거래량 (주)</th>
            </tr>
            <tr id="005930" onclick="sendStockDetail('005930')">
                <td class="stockTitle">삼성전자</td>
                <td id="price-005930">56,600원</td>
                <td id="prdy-005930">0</td>
                <td id="vol-005930">0</td>
            </tr>
            <tr id="000660" onclick="sendStockDetail('000660')">
                <td class="stockTitle">SK하이닉스</td>
                <td id="price-000660">203,000원</td>
                <td id="prdy-000660">0</td>
                <td id="vol-000660">0</td>
            </tr>
            <tr id="010140" onclick="sendStockDetail('010140')">
                <td class="stockTitle">삼성중공업</td>
                <td id="price-010140">14,890원</td>
                <td id="prdy-010140">0</td>
                <td id="vol-010140">0</td>
            </tr>
            <tr id="042660" onclick="sendStockDetail('042660')">
                <td class="stockTitle">한화오션</td>
                <td id="price-042660">72,700원</td>
                <td id="prdy-042660">0</td>
                <td id="vol-042660">0</td>
            </tr>
            <tr id="064350" onclick="sendStockDetail('064350')">
                <td class="stockTitle">현대로템</td>
                <td id="price-064350">85,600원</td>
                <td id="prdy-064350">0</td>
                <td id="vol-064350">0</td>
            </tr>
            <tr id="012450" onclick="sendStockDetail('012450')">
                <td class="stockTitle">한화에어로스페이스</td>
                <td id="price-012450">674,000원</td>
                <td id="prdy-012450">0</td>
                <td id="vol-012450">0</td>
            </tr>
            <tr id="035720" onclick="sendStockDetail('035720')">
                <td class="stockTitle">카카오</td>
                <td id="price-035720">42,050원</td>
                <td id="prdy-035720">0</td>
                <td id="vol-035720">0</td>
            </tr>
            <tr id="047050" onclick="sendStockDetail('047050')">
                <td class="stockTitle">포스코인터내셔널</td>
                <td id="price-047050">50,900원</td>
                <td id="prdy-047050">0</td>
                <td id="vol-047050">0</td>
            </tr>
            <tr id="005380" onclick="sendStockDetail('005380')">
                <td class="stockTitle">현대차</td>
                <td id="price-005380">204,500원</td>
                <td id="prdy-005380">0</td>
                <td id="vol-005380">0</td>
            </tr>
            <tr id="023590" onclick="sendStockDetail('023590')">
                <td class="stockTitle">다우기술</td>
                <td id="price-023590">21,400원</td>
                <td id="prdy-023590">0</td>
                <td id="vol-023590">0</td>
            </tr>
        </table>
    </div>
</div>

