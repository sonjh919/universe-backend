package com.dream.universe.friend.query.application.dto;

public class FriendQueryDTO {
    private long friendCode;
    private long memberCode;
    private long friendMemberCode;
    private String friendState;

    private String memberNickName;

    public FriendQueryDTO(){};

    public FriendQueryDTO(long friendCode, long memberCode, long friendMemberCode, String friendState, String memberNickName) {
        this.friendCode = friendCode;
        this.memberCode = memberCode;
        this.friendMemberCode = friendMemberCode;
        this.friendState = friendState;
        this.memberNickName = memberNickName;
    }

    public long getFriendCode() {
        return friendCode;
    }

    public void setFriendCode(long friendCode) {
        this.friendCode = friendCode;
    }

    public long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(long memberCode) {
        this.memberCode = memberCode;
    }

    public long getFriendMemberCode() {
        return friendMemberCode;
    }

    public void setFriendMemberCode(long friendMemberCode) {
        this.friendMemberCode = friendMemberCode;
    }

    public String getFriendState() {
        return friendState;
    }

    public void setFriendState(String friendState) {
        this.friendState = friendState;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    @Override
    public String toString() {
        return "FriendQueryDTO{" +
                "friendCode=" + friendCode +
                ", memberCode=" + memberCode +
                ", friendMemberCode=" + friendMemberCode +
                ", friendState='" + friendState + '\'' +
                ", memberNickName='" + memberNickName + '\'' +
                '}';
    }
}
