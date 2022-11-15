package com.dream.universe.member.dto;

public class MemberInfoDTO {
    private Long memberCode;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberPhone;
    private Long memberCap;
    private Long memberCherry;
    private String memberNickName;
    private String memberRole;

    private String memberMajor;

    private String memberWithdrawal;

    private String majorConcentration;
    private String majorKeyword;
    private String majorSpecialty;
    private String majorHopePath;

    private Long itemHairCode;
    private Long itemFaceCode;
    private Long itemClothCode;

    public MemberInfoDTO(){};

    public MemberInfoDTO(Long memberCode, String memberEmail, String memberPassword, String memberName, String memberPhone, Long memberCap, Long memberCherry, String memberNickName, String memberRole, String memberMajor, String memberWithdrawal, String majorConcentration, String majorKeyword, String majorSpecialty, String majorHopePath, Long itemHairCode, Long itemFaceCode, Long itemClothCode) {
        this.memberCode = memberCode;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberCap = memberCap;
        this.memberCherry = memberCherry;
        this.memberNickName = memberNickName;
        this.memberRole = memberRole;
        this.memberMajor = memberMajor;
        this.memberWithdrawal = memberWithdrawal;
        this.majorConcentration = majorConcentration;
        this.majorKeyword = majorKeyword;
        this.majorSpecialty = majorSpecialty;
        this.majorHopePath = majorHopePath;
        this.itemHairCode = itemHairCode;
        this.itemFaceCode = itemFaceCode;
        this.itemClothCode = itemClothCode;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
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

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Long getMemberCap() {
        return memberCap;
    }

    public void setMemberCap(Long memberCap) {
        this.memberCap = memberCap;
    }

    public Long getMemberCherry() {
        return memberCherry;
    }

    public void setMemberCherry(Long memberCherry) {
        this.memberCherry = memberCherry;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberMajor() {
        return memberMajor;
    }

    public void setMemberMajor(String memberMajor) {
        this.memberMajor = memberMajor;
    }

    public String getMemberWithdrawal() {
        return memberWithdrawal;
    }

    public void setMemberWithdrawal(String memberWithdrawal) {
        this.memberWithdrawal = memberWithdrawal;
    }

    public String getMajorConcentration() {
        return majorConcentration;
    }

    public void setMajorConcentration(String majorConcentration) {
        this.majorConcentration = majorConcentration;
    }

    public String getMajorKeyword() {
        return majorKeyword;
    }

    public void setMajorKeyword(String majorKeyword) {
        this.majorKeyword = majorKeyword;
    }

    public String getMajorSpecialty() {
        return majorSpecialty;
    }

    public void setMajorSpecialty(String majorSpecialty) {
        this.majorSpecialty = majorSpecialty;
    }

    public String getMajorHopePath() {
        return majorHopePath;
    }

    public void setMajorHopePath(String majorHopePath) {
        this.majorHopePath = majorHopePath;
    }

    public Long getItemHairCode() {
        return itemHairCode;
    }

    public void setItemHairCode(Long itemHairCode) {
        this.itemHairCode = itemHairCode;
    }

    public Long getItemFaceCode() {
        return itemFaceCode;
    }

    public void setItemFaceCode(Long itemFaceCode) {
        this.itemFaceCode = itemFaceCode;
    }

    public Long getItemClothCode() {
        return itemClothCode;
    }

    public void setItemClothCode(Long itemClothCode) {
        this.itemClothCode = itemClothCode;
    }

    @Override
    public String toString() {
        return "MemberInfoDTO{" +
                "memberCode=" + memberCode +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", memberCap=" + memberCap +
                ", memberCherry=" + memberCherry +
                ", memberNickName='" + memberNickName + '\'' +
                ", memberRole='" + memberRole + '\'' +
                ", memberMajor='" + memberMajor + '\'' +
                ", memberWithdrawal='" + memberWithdrawal + '\'' +
                ", majorConcentration='" + majorConcentration + '\'' +
                ", majorKeyword='" + majorKeyword + '\'' +
                ", majorSpecialty='" + majorSpecialty + '\'' +
                ", majorHopePath='" + majorHopePath + '\'' +
                ", itemHairCode=" + itemHairCode +
                ", itemFaceCode=" + itemFaceCode +
                ", itemClothCode=" + itemClothCode +
                '}';
    }
}
