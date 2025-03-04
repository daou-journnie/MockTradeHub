package org.example.mocktradehub.model;

import java.util.Date;

public class Stock {
    private String stockCode;
    private String stockName;
    private String stockType;
    private String stockMarket;
    private Date stockListingDate;
    private int stockIsActive;
    private int stockSharesOutstanding;
    private Date stockCreatedAt;
    private int stockClosingPrice;

    // Getters and Setters
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
    public String getStockType() {
        return stockType;
    }
    public void setStockType(String stockType) {
        this.stockType = stockType;
    }
    public String getStockMarket() {
        return stockMarket;
    }
    public void setStockMarket(String stockMarket) {
        this.stockMarket = stockMarket;
    }
    public Date getStockListingDate() {
        return stockListingDate;
    }
    public void setStockListingDate(Date stockListingDate) {
        this.stockListingDate = stockListingDate;
    }
    public int getStockIsActive() {
        return stockIsActive;
    }
    public void setStockIsActive(int stockIsActive) {
        this.stockIsActive = stockIsActive;
    }
    public int getStockSharesOutstanding() {
        return stockSharesOutstanding;
    }
    public void setStockSharesOutstanding(int stockSharesOutstanding) {
        this.stockSharesOutstanding = stockSharesOutstanding;
    }
    public Date getStockCreatedAt() {
        return stockCreatedAt;
    }
    public void setStockCreatedAt(Date stockCreatedAt) {
        this.stockCreatedAt = stockCreatedAt;
    }

    public int getStockClosingPrice() {
        return stockClosingPrice;
    }

    public void setStockClosingPrice(int stockClosingPrice) {
        this.stockClosingPrice = stockClosingPrice;
    }
}
