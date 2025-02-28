package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.mocktradehub.model.Stock;

import java.util.List;

public class StockDAO {

    public StockDAO() {}

    /**
     * 주어진 stockCode에 해당하는 stockName을 조회합니다.
     * @param stockCode 조회할 주식 코드
     * @return 주식 이름, 없으면 null
     */
    public String getStockNameByCode(SqlSession session, String stockCode) {
        String stockName = null;
        try {
            stockName =  session.selectOne("StockMapper.getStockNameByCode", stockCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stockName;
    }

}
