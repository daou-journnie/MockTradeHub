package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.mocktradehub.model.Member;


public class MemberDAO {

    public MemberDAO() {}

    public Member getMemberById(SqlSession session, String id) {
        return session.selectOne("MemberMapper.getMemberById", id);
    }



    public int insertMember(SqlSession session, Member member) {
        return session.insert("MemberMapper.insertMember", member);
    }


    public Member getMemberByNickname(SqlSession session, String memberNickname) {
        return session.selectOne("MemberMapper.getMemberByNickname", memberNickname);
    }

}
