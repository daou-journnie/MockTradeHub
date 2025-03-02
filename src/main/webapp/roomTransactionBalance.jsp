<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Room Transaction Balance</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/roomTransactionBalance.css">
</head>
<body>
<div class="balance-section">
    <!-- 잔액 카드 -->
    <div class="balance-card">
        <div class="balance-content">
            <div class="balance-info">
                <div class="balance-label">잔액</div>
                <div class="balance-amount">
                    <fmt:formatNumber value="${balance}" pattern="#,##0" />원
                </div>
            </div>
        </div>
    </div>
    <!-- 평가액 및 수익률 카드 -->
    <div class="value-card">
        <div class="value-content">
            <div class="market-value">
                <div class="value-label">총 자산</div>
                <div class="value-amount">
                    <fmt:formatNumber value="${totalAsset}" pattern="#,##0" />원
                </div>
            </div>
            <div class="profit-rate">
                <div class="rate-label">수익률</div>
                <div class="rate-value">
                    <fmt:formatNumber value="${totalProfitRate}" pattern="#,##0.00" />%
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>