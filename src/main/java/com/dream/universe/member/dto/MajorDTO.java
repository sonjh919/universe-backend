package com.dream.universe.member.dto;

public class MajorDTO {

    private Long memberCode;
    private String major;
    private String majorConcentration;
    private String majorKeyword;
    private String majorSpecialty;
    private String majorHopePath;

    public MajorDTO(){}

    public MajorDTO(Long memberCode, String major, String majorConcentration, String majorKeyword, String majorSpecialty, String majorHopePath) {
        this.memberCode = memberCode;
        this.major = major;
        this.majorConcentration = majorConcentration;
        this.majorKeyword = majorKeyword;
        this.majorSpecialty = majorSpecialty;
        this.majorHopePath = majorHopePath;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    @Override
    public String toString() {
        return "MajorDTO{" +
                "memberCode=" + memberCode +
                ", major='" + major + '\'' +
                ", majorConcentration='" + majorConcentration + '\'' +
                ", majorKeyword='" + majorKeyword + '\'' +
                ", majorSpecialty='" + majorSpecialty + '\'' +
                ", majorHopePath='" + majorHopePath + '\'' +
                '}';
    }
}
