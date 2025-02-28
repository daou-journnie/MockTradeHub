package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.MemberDAO;
import org.example.mocktradehub.model.Member;
import org.example.mocktradehub.util.MyBatisSessionFactory;

public class MemberService {
    private SqlSessionFactory factory;
    private MemberDAO memberDAO;

    public MemberService() {
        this.factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.memberDAO = new MemberDAO();
    }

    public Member getMemberById(String id) {
        try (SqlSession session = factory.openSession()) {
            return memberDAO.getMemberById(session, id);
        }
    }

    public boolean login(String id, String pw) {
        try (SqlSession session = factory.openSession()) {
            System.out.println("Service : " + id + " : " + pw);
            Member member = memberDAO.getMemberById(session, id);
            if (member != null && member.getMemberPassword().equals(pw)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("일치하는 아이디 없음");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    // 회원가입 기능
    // 성공하면 null, 실패하면 에러 메시지를 반환하도록 수정
    public String register(Member member) {
        try (SqlSession session = factory.openSession()) {
            // 아이디 중복 체크
            if(memberDAO.getMemberById(session, member.getMemberId()) != null) {
                System.out.println("이미 존재하는 아이디입니다.");
                return "이미 존재하는 아이디입니다.";
            }
            // 닉네임 중복 체크
            if(memberDAO.getMemberByNickname(session, member.getMemberNickname()) != null) {
                System.out.println("이미 존재하는 닉네임입니다.");
                return "이미 존재하는 닉네임입니다.";
            }

            int result = memberDAO.insertMember(session, member);
            // 등록 실패 시 처리 (원하는 메시지로 변경 가능)
            if(result <= 0) {
                session.rollback();
                return "회원가입에 실패했습니다.";
            }

            // 성공 시 커밋
            session.commit();
            return null; // null이면 성공
        } catch (Exception e) {
            e.printStackTrace();
            return "회원가입 처리 중 오류가 발생했습니다.";
        }
    }

    // 원금 계산;;


}
