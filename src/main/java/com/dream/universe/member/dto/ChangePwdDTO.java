package com.dream.universe.member.dto;

public class ChangePwdDTO {

    private String memberId;
    private String originPwd;
    private String memberPwd;

    public ChangePwdDTO(){}

    public ChangePwdDTO(String memberId, String originPwd, String memberPwd) {
        this.memberId = memberId;
        this.originPwd = originPwd;
        this.memberPwd = memberPwd;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOriginPwd() {
        return originPwd;
    }

    public void setOriginPwd(String originPwd) {
        this.originPwd = originPwd;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    @Override
    public String toString() {
        return "ChangePwdDTO{" +
                "memberId='" + memberId + '\'' +
                ", originPwd='" + originPwd + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                '}';
    }
}
