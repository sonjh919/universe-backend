package com.dream.universe.like.command.application.dto;

public class LikeDTO {
    private long likeCode;
    private long spaceCode;
    private long memberCode;

    public LikeDTO(){}

    public LikeDTO(long likeCode, long spaceCode, long memberCode) {
        this.likeCode = likeCode;
        this.spaceCode = spaceCode;
        this.memberCode = memberCode;
    }

    public long getLikeCode() {
        return likeCode;
    }

    public void setLikeCode(long likeCode) {
        this.likeCode = likeCode;
    }

    public long getSpaceCode() {
        return spaceCode;
    }

    public void setSpaceCode(long spaceCode) {
        this.spaceCode = spaceCode;
    }

    public long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(long memberCode) {
        this.memberCode = memberCode;
    }

    @Override
    public String toString() {
        return "LikeDTO{" +
                "likeCode=" + likeCode +
                ", spaceCode=" + spaceCode +
                ", memberCode=" + memberCode +
                '}';
    }
}
