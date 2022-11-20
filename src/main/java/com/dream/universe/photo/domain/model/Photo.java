package com.dream.universe.photo.domain.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "SEQ_TB_PHOTO_CODE"
        , sequenceName = "SEQ_TB_PHOTO_CODE"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_PHOTO")
public class Photo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "SEQ_TB_PHOTO_CODE"
    )
    @Column(name="PHOTO_CODE")
    private long photoCode;

    @Column(name="MEMBER_CODE")
    private long memberCode;

    @Column(name="PHOTO_URL")
    private String photoUrl;

    @Column(name="PHOTO_TYPE")
    private String photoType;

    public Photo(){}

    public Photo(long photoCode, long memberCode, String photoUrl, String photoType) {
        this.photoCode = photoCode;
        this.memberCode = memberCode;
        this.photoUrl = photoUrl;
        this.photoType = photoType;
    }

    public long getPhotoCode() {
        return photoCode;
    }

    public void setPhotoCode(long photoCode) {
        this.photoCode = photoCode;
    }

    public long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(long memberCode) {
        this.memberCode = memberCode;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoCode=" + photoCode +
                ", memberCode=" + memberCode +
                ", photoUrl='" + photoUrl + '\'' +
                ", photoType='" + photoType + '\'' +
                '}';
    }
}
