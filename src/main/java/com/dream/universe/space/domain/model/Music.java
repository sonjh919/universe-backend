package com.dream.universe.space.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_MUSIC")
public class Music {

    @Id
    @Column(name = "SPACE_CODE")
    private long spaceCode;

    @Column(name = "MUSIC_URL")
    private String musicUrl;

    public Music(){}

    public Music(long spaceCode, String musicUrl) {
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
        return "Music{" +
                "spaceCode=" + spaceCode +
                ", musicUrl='" + musicUrl + '\'' +
                '}';
    }
}
