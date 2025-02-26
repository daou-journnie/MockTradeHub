<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주식 가격 실시간</title>
    <script src="js/websocket.js"></script>
    <link rel="stylesheet" type="text/css" href="css/stocklist.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
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
            <tr>
                <td class="stockTitle"><a href="#">삼성전자</a></td>
                <td id="price-005930">56,600원</td>
                <td id="prdy-005930">0</td>
                <td id="vol-005930">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">SK하이닉스</a></td>
                <td id="price-000660">203,000원</td>
                <td id="prdy-000660">0</td>
                <td id="vol-000660">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">삼성중공업</a></td>
                <td id="price-010140">14,890원</td>
                <td id="prdy-010140">0</td>
                <td id="vol-010140">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">한화오션</a></td>
                <td id="price-042660">72,700원</td>
                <td id="prdy-042660">0</td>
                <td id="vol-042660">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">현대로템</a></td>
                <td id="price-064350">85,600원</td>
                <td id="prdy-064350">0</td>
                <td id="vol-064350">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">한화에어로스페이스</a></td>
                <td id="price-012450">674,000원</td>
                <td id="prdy-012450">0</td>
                <td id="vol-012450">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">카카오</a></td>
                <td id="price-035720">42,050원</td>
                <td id="prdy-035720">0</td>
                <td id="vol-035720">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">포스코인터내셔널</a></td>
                <td id="price-047050">50,900원</td>
                <td id="prdy-047050">0</td>
                <td id="vol-047050">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">현대차</a></td>
                <td id="price-005380">204,500원</td>
                <td id="prdy-005380">0</td>
                <td id="vol-005380">0</td>
            </tr>
            <tr>
                <td class="stockTitle"><a href="#">다우기술</a></td>
                <td id="price-023590">21,400원</td>
                <td id="prdy-023590">0</td>
                <td id="vol-023590">0</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
