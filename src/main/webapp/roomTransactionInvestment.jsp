<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.mocktradehub.model.Portfolio" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>방 대시보드 - 보유 주식</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/roomTransactionInvestment.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
</head>
<body>
<div class="stock-holdings">
    <h2 class="stock-holdings__title">보유 주식</h2>
    <div class="stock-holdings__table-wrapper">
        <div class="stock-holdings__table">
            <div class="stock-holdings__header">
                <div class="stock-holdings__header-cell">종목명</div>
                <div class="stock-holdings__header-cell">1주 평균금액</div>
                <div class="stock-holdings__header-cell">현재가</div>
                <div class="stock-holdings__header-cell">보유수량</div>
                <div class="stock-holdings__header-cell">평가금</div>
                <div class="stock-holdings__header-cell">원금</div>
                <div class="stock-holdings__header-cell">총 수익률</div>
            </div>
            <c:choose>
                <c:when test="${not empty portfolioList}">
                    <c:forEach var="portfolio" items="${portfolioList}">
                        <div class="stock-holdings__row">
                            <div class="stock-holdings__cell">${portfolio.stockName}</div>
                            <div class="stock-holdings__cell">
                                <fmt:formatNumber value="${portfolio.averagePrice}" pattern="#,##0" />원
                            </div>
                            <div class="stock-holdings__cell">
                                <fmt:formatNumber value="${portfolio.currentPrice}" pattern="#,##0" />원
                            </div>
                            <div class="stock-holdings__cell">${portfolio.holdingQuantity} 주</div>
                            <div class="stock-holdings__cell">
                                <fmt:formatNumber value="${portfolio.evaluationValue}" pattern="#,##0" />원
                            </div>
                            <div class="stock-holdings__cell">
                                <fmt:formatNumber value="${portfolio.principal}" pattern="#,##0" />원
                            </div>
                            <div class="stock-holdings__cell">
                                <fmt:formatNumber value="${portfolio.totalProfitRate}" pattern="#,##0.00" />%
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="stock-holdings__row">
                        <div class="stock-holdings__cell" style="width:100%;">보유 주식이 없습니다.</div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>