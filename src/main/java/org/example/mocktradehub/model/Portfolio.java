package org.example.mocktradehub.model;

public class Portfolio {
    // 종목명
    private String stockName;
    // 1주 평균금액
    private int averagePrice;
    // 현재가
    private int currentPrice;
    // 보유수량
    private int holdingQuantity;
    // 평가금
    private int evaluationValue;
    // 원금
    private int principal;
    // 총 수익률 (예: 퍼센트 값, 소수점 포함)
    private int totalProfitRate;
    // 방 멤버 아이디
    private int roomMemberId;

    public Portfolio() {
    }

    public Portfolio(String stockName, int averagePrice, int currentPrice, int holdingQuantity,
                     int evaluationValue, int principal, int totalProfitRate, int roomMemberId) {
        this.stockName = stockName;
        this.averagePrice = averagePrice;
        this.currentPrice = currentPrice;
        this.holdingQuantity = holdingQuantity;
        this.evaluationValue = evaluationValue;
        this.principal = principal;
        this.totalProfitRate = totalProfitRate;
        this.roomMemberId = roomMemberId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(int averagePrice) {
        this.averagePrice = averagePrice;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getHoldingQuantity() {
        return holdingQuantity;
    }

    public void setHoldingQuantity(int holdingQuantity) {
        this.holdingQuantity = holdingQuantity;
    }

    public int getEvaluationValue() {
        return evaluationValue;
    }

    public void setEvaluationValue(int evaluationValue) {
        this.evaluationValue = evaluationValue;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getTotalProfitRate() {
        return totalProfitRate;
    }

    public void setTotalProfitRate(int totalProfitRate) {
        this.totalProfitRate = totalProfitRate;
    }

    public int getRoomMemberId() {
        return roomMemberId;
    }

    public void setRoomMemberId(int roomMemberId) {
        this.roomMemberId = roomMemberId;
    }

    @Override
    public String toString() {
        return "PortfolioVO{" +
                "stockName='" + stockName + '\'' +
                ", averagePrice=" + averagePrice +
                ", currentPrice=" + currentPrice +
                ", holdingQuantity=" + holdingQuantity +
                ", evaluationValue=" + evaluationValue +
                ", principal=" + principal +
                ", totalProfitRate=" + totalProfitRate +
                ", roomMemberId=" + roomMemberId +
                '}';
    }
}
