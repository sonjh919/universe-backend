package com.dream.universe.friend.command.application.dto;

public class FriendDTO {
    private long friendCode;
    private long memberCode;
    private long friendMemberCode;
    private String friendState;

    public FriendDTO(){}

    public FriendDTO(long friendCode, long memberCode, long friendMemberCode, String friendState) {
        this.friendCode = friendCode;
        this.memberCode = memberCode;
        this.friendMemberCode = friendMemberCode;
        this.friendState = friendState;
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

    @Override
    public String toString() {
        return "FriendDTO{" +
                "friendCode=" + friendCode +
                ", memberCode=" + memberCode +
                ", friendMemberCode=" + friendMemberCode +
                ", friendState='" + friendState + '\'' +
                '}';
    }
}
