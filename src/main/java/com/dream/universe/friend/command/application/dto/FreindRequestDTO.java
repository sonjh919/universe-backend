package com.dream.universe.friend.command.application.dto;

public class FreindRequestDTO {
    private String friendMemberId;

    public FreindRequestDTO(){}

    public FreindRequestDTO(String friendMemberId) {
        this.friendMemberId = friendMemberId;
    }

    public String getFriendMemberId() {
        return friendMemberId;
    }

    public void setFriendMemberId(String friendMemberId) {
        this.friendMemberId = friendMemberId;
    }

    @Override
    public String toString() {
        return "FreindRequestDTO{" +
                "friendMemberId='" + friendMemberId + '\'' +
                '}';
    }
}
