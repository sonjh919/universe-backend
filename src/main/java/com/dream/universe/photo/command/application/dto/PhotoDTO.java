package com.dream.universe.photo.command.application.dto;

public class PhotoDTO {

    private long photoCode;

    private long memberCode;

    private String photoUrl;

    private String photoType;

    public PhotoDTO(){}

    public PhotoDTO(long photoCode, long memberCode, String photoUrl, String photoType) {
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
        return "PhotoDTO{" +
                "photoCode=" + photoCode +
                ", memberCode=" + memberCode +
                ", photoUrl='" + photoUrl + '\'' +
                ", photoType='" + photoType + '\'' +
                '}';
    }
}
