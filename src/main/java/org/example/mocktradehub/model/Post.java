package org.example.mocktradehub.model;

import java.util.Date;

public class Post {
    private int postId;
    private String postContent;
    private Date postCreatedAt;
    private Integer postParentId;  // 부모 포스트(댓글) 관련, 필요시 사용
    private int roomId;
    private String memberId;
    private String memberNickname;

    // Getters and Setters
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public String getPostContent() {
        return postContent;
    }
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    public Date getPostCreatedAt() {
        return postCreatedAt;
    }
    public void setPostCreatedAt(Date postCreatedAt) {
        this.postCreatedAt = postCreatedAt;
    }
    public Integer getPostParentId() {
        return postParentId;
    }
    public void setPostParentId(Integer postParentId) {
        this.postParentId = postParentId;
    }
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }
}
