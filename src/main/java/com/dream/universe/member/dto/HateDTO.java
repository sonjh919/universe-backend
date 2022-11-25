package com.dream.universe.member.dto;

public class HateDTO {
    private String data;
    public HateDTO(){}

    public HateDTO(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HateDTO{" +
                "data='" + data + '\'' +
                '}';
    }
}
