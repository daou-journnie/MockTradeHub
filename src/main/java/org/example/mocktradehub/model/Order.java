package org.example.mocktradehub.model;

public class Order {
    private int orderId;
    private int roomMemberId;      // ORDERS.ROOM_MEMBER_ID
    private int roomID;
    private String orderType;      // 'BUY' 또는 'SELL'
    private int orderTotalQuantity;
    private int orderPrice;
    private String orderTime;      // 문자열로 저장 (YYYY-MM-DD HH24:MI:SS)
    private String stockCode;      // 주문한 주식 코드
    private String stockName;


    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getRoomMemberId() {
        return roomMemberId;
    }
    public void setRoomMemberId(int roomMemberId) {
        this.roomMemberId = roomMemberId;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getOrderType() {
        return orderType;
    }
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    public int getOrderTotalQuantity() {
        return orderTotalQuantity;
    }
    public void setOrderTotalQuantity(int orderTotalQuantity) {
        this.orderTotalQuantity = orderTotalQuantity;
    }
    public int getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
    public String getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
    public String getStockCode() {
        return stockCode;
    }
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}
