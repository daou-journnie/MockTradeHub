package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.StockDAO;
import org.example.mocktradehub.model.Stock;
import org.example.mocktradehub.util.MyBatisSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockService {
    private SqlSessionFactory factory;
    private StockDAO stockDAO;

    public StockService() {
        this.factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.stockDAO = new StockDAO();
    }

    public Map<String, Integer> getStockClosingPrice() {
        SqlSession session = factory.openSession();
        List<Stock> stockPriceList = stockDAO.getStockClosingPrice(session);
        session.close();

        Map<String, Integer> stockPriceMap = new HashMap<>();
        for (Stock s:stockPriceList) {
            stockPriceMap.put(s.getStockCode(), s.getStockClosingPrice());
        }

        return stockPriceMap;
    }
}
