package com.dream.universe.portfolio.domain.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "SEQ_TB_PORTFOLIO_CODE"
        , sequenceName = "SEQ_TB_PORTFOLIO_CODE"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_PORTFOLIO")
public class Portfolio {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "SEQ_TB_PORTFOLIO_CODE"
    )

    @Column(name="PORTFOLIO_CODE")
    private long portfolioCode;

    @Column(name="MEMBER_CODE")
    private long memberCode;

    @Column(name="PORTFOLIO_INDEX")
    private long portfolioIndex;

    @Column(name="PORTFOLIO_NAME")
    private String portfolioName;

    @Column(name="PORTFOLIO_LINK")
    private String portfolioLink;

    public Portfolio(){}

    public Portfolio(long portfolioCode, long memberCode, long portfolioIndex, String portfolioName, String portfolioLink) {
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
        return "Portfolio{" +
                "portfolioCode=" + portfolioCode +
                ", memberCode=" + memberCode +
                ", portfolioIndex=" + portfolioIndex +
                ", portfolioName='" + portfolioName + '\'' +
                ", portfolioLink='" + portfolioLink + '\'' +
                '}';
    }
}
