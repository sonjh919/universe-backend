package com.dream.universe.space.command.application.dto;

public class MusicDTO {

    private long spaceCode;

    private String musicUrl;

    public MusicDTO(){}

    public MusicDTO(long spaceCode, String musicUrl) {
        this.spaceCode = spaceCode;
        this.musicUrl = musicUrl;
    }

    public long getSpaceCode() {
        return spaceCode;
    }

    public void setSpaceCode(long spaceCode) {
        this.spaceCode = spaceCode;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    @Override
    public String toString() {
        return "MusicDTO{" +
                "spaceCode=" + spaceCode +
                ", musicUrl='" + musicUrl + '\'' +
                '}';
    }
}
