package org.example.mocktradehub.model;

import java.util.Date;

public class Room {
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
    private Date roomCreatedAt;
    private Date roomUpdatedAt;
    private Date roomDeletedAt;

    // Getters and Setters

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

    public Date getRoomCreatedAt() {
        return roomCreatedAt;
    }
    public void setRoomCreatedAt(Date roomCreatedAt) {
        this.roomCreatedAt = roomCreatedAt;
    }

    public Date getRoomUpdatedAt() {
        return roomUpdatedAt;
    }
    public void setRoomUpdatedAt(Date roomUpdatedAt) {
        this.roomUpdatedAt = roomUpdatedAt;
    }

    public Date getRoomDeletedAt() {
        return roomDeletedAt;
    }
    public void setRoomDeletedAt(Date roomDeletedAt) {
        this.roomDeletedAt = roomDeletedAt;
    }
}
