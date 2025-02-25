package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.Member;


public class MemberDAO {
    private SqlSessionFactory sqlSessionFactory;

    public MemberDAO(SqlSessionFactory factory) {
        this.sqlSessionFactory = factory;
    }

    public Member getMemberById(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        Member member = null;
        try {
            member = session.selectOne("MemberMapper.getMemberById", id);
        } finally {
            session.close();
        }
        return member;
    }


}
