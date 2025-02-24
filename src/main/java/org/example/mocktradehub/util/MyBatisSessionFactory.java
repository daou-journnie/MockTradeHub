package org.example.mocktradehub.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.logging.Logger;

// SqlSession 객체를 뽑아내는 일 - SqlSession이 있어야 SQL 실행 가능
public class MyBatisSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        Logger logger = Logger.getLogger(MyBatisSessionFactory.class.getName());
        try {
            String resource = "./SqlMapConfig.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            if(sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}

