package com.dream.universe.space.domain.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "SEQ_TB_SPACE_CODE"
        , sequenceName = "SEQ_TB_SPACE_CODE"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_SPACE")
public class Space {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "SEQ_TB_SPACE_CODE"
    )

    @Column(name = "SPACE_CODE")
    private long spaceCode;

    @Column(name = "MEMBER_CODE")
    private long memberCode;

    @Column(name = "SPACE_NAME")
    private String spaceName;

    @Column(name = "SPACE_INTRO")
    private String spaceIntro;

    @Column(name = "SPACE_PASSWORD")
    private String friendState;

    @Column(name = "SPACE_MAPINFO")
    private String spaceMapinfo;

    @Column(name = "SPACE_LIKE")
    private long spaceLike;

    @Column(name = "SPACE_THUMBNAIL")
    private String spaceThumbnail;

    @Column(name = "SPACE_REPORT")
    private long spaceReport;

    @Column(name = "SPACE_WARNING")
    private long spaceWarning;

    @Column(name = "SPACE_TAG1")
    private long spaceTag1;

    @Column(name = "SPACE_TAG2")
    private long spaceTag2;

    @Column(name = "SPACE_TAG3")
    private long spaceTag3;

    public Space(){};

    public Space(long spaceCode, long memberCode, String spaceName, String spaceIntro, String friendState, String spaceMapinfo, long spaceLike, String spaceThumbnail, long spaceReport, long spaceWarning, long spaceTag1, long spaceTag2, long spaceTag3) {
        this.spaceCode = spaceCode;
        this.memberCode = memberCode;
        this.spaceName = spaceName;
        this.spaceIntro = spaceIntro;
        this.friendState = friendState;
        this.spaceMapinfo = spaceMapinfo;
        this.spaceLike = spaceLike;
        this.spaceThumbnail = spaceThumbnail;
        this.spaceReport = spaceReport;
        this.spaceWarning = spaceWarning;
        this.spaceTag1 = spaceTag1;
        this.spaceTag2 = spaceTag2;
        this.spaceTag3 = spaceTag3;
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

    public String getFriendState() {
        return friendState;
    }

    public void setFriendState(String friendState) {
        this.friendState = friendState;
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

    public long getSpaceTag1() {
        return spaceTag1;
    }

    public void setSpaceTag1(long spaceTag1) {
        this.spaceTag1 = spaceTag1;
    }

    public long getSpaceTag2() {
        return spaceTag2;
    }

    public void setSpaceTag2(long spaceTag2) {
        this.spaceTag2 = spaceTag2;
    }

    public long getSpaceTag3() {
        return spaceTag3;
    }

    public void setSpaceTag3(long spaceTag3) {
        this.spaceTag3 = spaceTag3;
    }

    @Override
    public String toString() {
        return "Space{" +
                "spaceCode=" + spaceCode +
                ", memberCode=" + memberCode +
                ", spaceName='" + spaceName + '\'' +
                ", spaceIntro='" + spaceIntro + '\'' +
                ", friendState='" + friendState + '\'' +
                ", spaceMapinfo='" + spaceMapinfo + '\'' +
                ", spaceLike=" + spaceLike +
                ", spaceThumbnail='" + spaceThumbnail + '\'' +
                ", spaceReport=" + spaceReport +
                ", spaceWarning=" + spaceWarning +
                ", spaceTag1=" + spaceTag1 +
                ", spaceTag2=" + spaceTag2 +
                ", spaceTag3=" + spaceTag3 +
                '}';
    }
}