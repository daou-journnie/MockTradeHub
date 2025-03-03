package org.example.mocktradehub.model;

import java.util.Date;

public class RoomMember {
    private int roomMemberId;
    private String memberId;
    private String memberNickname;
    private int roomMemberBalance;
    private int roomId;              // 자동 생성 (시퀀스)
    private String roomCode;
    private String roomName;
    private int roomIsPublic;        // 0 또는 1
    private String roomDescription;
    private String roomStatus;       // 'ACTIVE', 'INACTIVE', 'CLOSED'
    private int roomInitialSeed;     // 초기 시드금액
    private int roomMaxMembers;      // 최대 인원, 기본 10
    private String roomCreatedBy;
    private Date roomStartDate;
    private Date roomEndDate;
    private Date roomJoinedAt;

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public RoomMember() {
    }

    public RoomMember(int roomMemberId, String memberId, int roomMemberBalance, String roomCode, String roomName, String roomStatus, String roomDescription, int roomIsPublic) {
        this.roomMemberId = roomMemberId;
        this.memberId = memberId;
        this.roomMemberBalance = roomMemberBalance;
        this.roomCode = roomCode;
        this.roomName = roomName;
        this.roomStatus = roomStatus;
        this.roomDescription = roomDescription;
        this.roomIsPublic = roomIsPublic;
    }

    public RoomMember(int roomMemberId, String memberId, String memberNickname, int roomMemberBalance, int roomInitialSeed) {
        this.roomMemberId = roomMemberId;
        this.memberId = memberId;
        this.memberNickname = memberNickname;
        this.roomMemberBalance = roomMemberBalance;
        this.roomInitialSeed = roomInitialSeed;
    }
    public int getRoomMemberId() {
        return roomMemberId;
    }

    public int getRoomMemberBalance() {
        return roomMemberBalance;
    }

    public void setRoomMemberBalance(int roomMemberBalance) {
        this.roomMemberBalance = roomMemberBalance;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomIsPublic() {
        return roomIsPublic;
    }

    public void setRoomIsPublic(int roomIsPublic) {
        this.roomIsPublic = roomIsPublic;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getRoomInitialSeed() {
        return roomInitialSeed;
    }

    public void setRoomInitialSeed(int roomInitialSeed) {
        this.roomInitialSeed = roomInitialSeed;
    }

    public int getRoomMaxMembers() {
        return roomMaxMembers;
    }

    public void setRoomMaxMembers(int roomMaxMembers) {
        this.roomMaxMembers = roomMaxMembers;
    }

    public String getRoomCreatedBy() {
        return roomCreatedBy;
    }

    public void setRoomCreatedBy(String roomCreatedBy) {
        this.roomCreatedBy = roomCreatedBy;
    }

    public Date getRoomStartDate() {
        return roomStartDate;
    }

    public void setRoomStartDate(Date roomStartDate) {
        this.roomStartDate = roomStartDate;
    }

    public Date getRoomEndDate() {
        return roomEndDate;
    }

    public void setRoomEndDate(Date roomEndDate) {
        this.roomEndDate = roomEndDate;
    }

    public Date getRoomJoinedAt() {
        return roomJoinedAt;
    }

    public void setRoomJoinedAt(Date roomJoinedAt) {
        this.roomJoinedAt = roomJoinedAt;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setRoomMemberId(int roomMemberId) {
        this.roomMemberId = roomMemberId;
    }
}
