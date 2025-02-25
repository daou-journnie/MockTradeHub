package org.example.mocktradehub.model;

import java.util.Date;

public class Member {
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberNickname;
    private Date memberCreatedAt;
    private int memberIsActive;
    private Date memberDeletedAt;


    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPassword() {
        return memberPassword;
    }
    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNickname() {
        return memberNickname;
    }
    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public Date getMemberCreatedAt() {
        return memberCreatedAt;
    }
    public void setMemberCreatedAt(Date memberCreatedAt) {
        this.memberCreatedAt = memberCreatedAt;
    }

    public int getMemberIsActive() {
        return memberIsActive;
    }
    public void setMemberIsActive(int memberIsActive) {
        this.memberIsActive = memberIsActive;
    }

    public Date getMemberDeletedAt() {
        return memberDeletedAt;
    }
    public void setMemberDeletedAt(Date memberDeletedAt) {
        this.memberDeletedAt = memberDeletedAt;
    }
}
