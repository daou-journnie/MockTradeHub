<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>거래 내역</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/roomTransactionHistory.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
</head>
<body>
<div class="transaction-history">
    <h2 class="transaction-title">거래 내역</h2>
    <div class="transaction-container">
        <c:if test="${not empty orderList}">
            <c:forEach var="order" items="${orderList}">
                <div class="transaction-item">
                    <div class="transaction-info">
                        <div class="transaction-date">
                            <!-- 주문시간에서 처음 10자("YYYY-MM-DD")를 추출한 후 "-"를 공백으로 치환 -->
                                ${fn:replace(fn:substring(order.orderTime, 0, 10), "-", " ")}
                        </div>
                        <div class="transaction-details">
                            <div class="transaction-company">${order.stockName}</div>
                            <div class="transaction-period">${order.orderTotalQuantity}주</div>
                            <div class="transaction-type">
                                <c:choose>
                                    <c:when test="${order.orderType eq 'SELL'}">판매</c:when>
                                    <c:otherwise>구매</c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <div class="transaction-financials">
                        <div class="transaction-amount">
                            <c:choose>
                                <c:when test="${order.orderType eq 'BUY'}">
                                    -<fmt:formatNumber value="${order.orderTotalQuantity * order.orderPrice}" pattern="#,##0" />원
                                </c:when>
                                <c:otherwise>
                                    <fmt:formatNumber value="${order.orderTotalQuantity * order.orderPrice}" pattern="#,##0" />원
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${empty orderList}">
            <p>거래 내역이 없습니다.</p>
        </c:if>
    </div>
</div>
</body>
</html>