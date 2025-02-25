package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.MemberDAO;
import org.example.mocktradehub.util.MyBatisSessionFactory;

public class MemberService {
    private MemberDAO memberDAO;

    public MemberService() {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.memberDAO = new MemberDAO(factory);
    }

    public boolean login(String id, String pw) {
        System.out.println("Service : " + id + " : " + pw);
        try {
            if(memberDAO.getMemberById(id).getMemberPassword().equals(pw)) {
                return true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("일치하는 아이디 없음");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
