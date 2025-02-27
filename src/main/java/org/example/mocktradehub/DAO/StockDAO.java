package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class StockDAO {
    private SqlSessionFactory sqlSessionFactory;

    public StockDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 주어진 stockCode에 해당하는 stockName을 조회합니다.
     * @param stockCode 조회할 주식 코드
     * @return 주식 이름, 없으면 null
     */
    public String getStockNameByCode(String stockCode) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectOne("StockMapper.getStockNameByCode", stockCode);
        } finally {
            session.close();
        }
    }
}
