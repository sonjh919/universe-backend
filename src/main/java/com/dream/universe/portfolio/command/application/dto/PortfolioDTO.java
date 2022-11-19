package com.dream.universe.portfolio.command.application.dto;

public class PortfolioDTO {

    private long portfolioCode;

    private long memberCode;

    private long portfolioIndex;

    private String portfolioName;

    private String portfolioLink;

    public PortfolioDTO(){}

    public PortfolioDTO(long portfolioCode, long memberCode, long portfolioIndex, String portfolioName, String portfolioLink) {
        this.portfolioCode = portfolioCode;
        this.memberCode = memberCode;
        this.portfolioIndex = portfolioIndex;
        this.portfolioName = portfolioName;
        this.portfolioLink = portfolioLink;
    }

    public long getPortfolioCode() {
        return portfolioCode;
    }

    public void setPortfolioCode(long portfolioCode) {
        this.portfolioCode = portfolioCode;
    }

    public long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(long memberCode) {
        this.memberCode = memberCode;
    }

    public long getPortfolioIndex() {
        return portfolioIndex;
    }

    public void setPortfolioIndex(long portfolioIndex) {
        this.portfolioIndex = portfolioIndex;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getPortfolioLink() {
        return portfolioLink;
    }

    public void setPortfolioLink(String portfolioLink) {
        this.portfolioLink = portfolioLink;
    }

    @Override
    public String toString() {
        return "PortfolioDTO{" +
                "portfolioCode=" + portfolioCode +
                ", memberCode=" + memberCode +
                ", portfolioIndex=" + portfolioIndex +
                ", portfolioName='" + portfolioName + '\'' +
                ", portfolioLink='" + portfolioLink + '\'' +
                '}';
    }
}
