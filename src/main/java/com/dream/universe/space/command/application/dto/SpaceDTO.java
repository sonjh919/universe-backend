package com.dream.universe.space.command.application.dto;

public class SpaceDTO {

    private long spaceCode;
    private long memberCode;
    private String spaceName;
    private String spaceIntro;
    private String spacePassword;
    private String spaceMapinfo;
    private long spaceLike;
    private String spaceThumbnail;
    private long spaceReport;
    private long spaceWarning;

    public SpaceDTO(){};

    public SpaceDTO(long spaceCode, long memberCode, String spaceName, String spaceIntro, String spacePassword, String spaceMapinfo, long spaceLike, String spaceThumbnail, long spaceReport, long spaceWarning) {
        this.spaceCode = spaceCode;
        this.memberCode = memberCode;
        this.spaceName = spaceName;
        this.spaceIntro = spaceIntro;
        this.spacePassword = spacePassword;
        this.spaceMapinfo = spaceMapinfo;
        this.spaceLike = spaceLike;
        this.spaceThumbnail = spaceThumbnail;
        this.spaceReport = spaceReport;
        this.spaceWarning = spaceWarning;
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

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceIntro() {
        return spaceIntro;
    }

    public void setSpaceIntro(String spaceIntro) {
        this.spaceIntro = spaceIntro;
    }

    public String getSpacePassword() {
        return spacePassword;
    }

    public void setSpacePassword(String spacePassword) {
        this.spacePassword = spacePassword;
    }

    public String getSpaceMapinfo() {
        return spaceMapinfo;
    }

    public void setSpaceMapinfo(String spaceMapinfo) {
        this.spaceMapinfo = spaceMapinfo;
    }

    public long getSpaceLike() {
        return spaceLike;
    }

    public void setSpaceLike(long spaceLike) {
        this.spaceLike = spaceLike;
    }

    public String getSpaceThumbnail() {
        return spaceThumbnail;
    }

    public void setSpaceThumbnail(String spaceThumbnail) {
        this.spaceThumbnail = spaceThumbnail;
    }

    public long getSpaceReport() {
        return spaceReport;
    }

    public void setSpaceReport(long spaceReport) {
        this.spaceReport = spaceReport;
    }

    public long getSpaceWarning() {
        return spaceWarning;
    }

    public void setSpaceWarning(long spaceWarning) {
        this.spaceWarning = spaceWarning;
    }

    @Override
    public String toString() {
        return "SpaceDTO{" +
                "spaceCode=" + spaceCode +
                ", memberCode=" + memberCode +
                ", spaceName='" + spaceName + '\'' +
                ", spaceIntro='" + spaceIntro + '\'' +
                ", spacePassword='" + spacePassword + '\'' +
                ", spaceMapinfo='" + spaceMapinfo + '\'' +
                ", spaceLike=" + spaceLike +
                ", spaceThumbnail='" + spaceThumbnail + '\'' +
                ", spaceReport=" + spaceReport +
                ", spaceWarning=" + spaceWarning +
                '}';
    }
}
