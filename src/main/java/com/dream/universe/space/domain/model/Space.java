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
    private long spaceName;

    @Column(name = "SPACE_INTRO")
    private long spaceIntro;

    @Column(name = "SPACE_PASSWORD")
    private String friendState;

    @Column(name = "SPACE_MAPINFO")
    private String spaceMapinfo;

    @Column(name = "SPACE_LIKE")
    private String spaceLike;

    @Column(name = "SPACE_THUMBNAIL")
    private String spaceThumbnail;

    @Column(name = "SPACE_REPORT")
    private String spaceReport;

    @Column(name = "SPACE_WARNING")
    private String spaceWarning;

    public Space(){};

    public Space(long spaceCode, long memberCode, long spaceName, long spaceIntro, String friendState, String spaceMapinfo, String spaceLike, String spaceThumbnail, String spaceReport, String spaceWarning) {
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

    public long getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(long spaceName) {
        this.spaceName = spaceName;
    }

    public long getSpaceIntro() {
        return spaceIntro;
    }

    public void setSpaceIntro(long spaceIntro) {
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

    public String getSpaceLike() {
        return spaceLike;
    }

    public void setSpaceLike(String spaceLike) {
        this.spaceLike = spaceLike;
    }

    public String getSpaceThumbnail() {
        return spaceThumbnail;
    }

    public void setSpaceThumbnail(String spaceThumbnail) {
        this.spaceThumbnail = spaceThumbnail;
    }

    public String getSpaceReport() {
        return spaceReport;
    }

    public void setSpaceReport(String spaceReport) {
        this.spaceReport = spaceReport;
    }

    public String getSpaceWarning() {
        return spaceWarning;
    }

    public void setSpaceWarning(String spaceWarning) {
        this.spaceWarning = spaceWarning;
    }

    @Override
    public String toString() {
        return "Space{" +
                "spaceCode=" + spaceCode +
                ", memberCode=" + memberCode +
                ", spaceName=" + spaceName +
                ", spaceIntro=" + spaceIntro +
                ", friendState='" + friendState + '\'' +
                ", spaceMapinfo='" + spaceMapinfo + '\'' +
                ", spaceLike='" + spaceLike + '\'' +
                ", spaceThumbnail='" + spaceThumbnail + '\'' +
                ", spaceReport='" + spaceReport + '\'' +
                ", spaceWarning='" + spaceWarning + '\'' +
                '}';
    }
}