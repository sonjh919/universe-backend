package com.dream.universe.like.command.domain.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "SEQ_TB_LIKE_CODE"
        , sequenceName = "SEQ_TB_LIKE_CODE"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_LIKE")
public class Like {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "SEQ_TB_LIKE_CODE"
    )
    @Column(name="LIKE_CODE")
    private long likeCode;

    @Column(name="SPACE_CODE")
    private long spaceCode;

    @Column(name="MEMBER_CODE")
    private long memberCode;

    public Like(){}

    public Like(long likeCode, long spaceCode, long memberCode) {
        this.likeCode = likeCode;
        this.spaceCode = spaceCode;
        this.memberCode = memberCode;
    }

    public long getLikeCode() {
        return likeCode;
    }

    public void setLikeCode(long likeCode) {
        this.likeCode = likeCode;
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

    @Override
    public String toString() {
        return "Like{" +
                "likeCode=" + likeCode +
                ", spaceCode=" + spaceCode +
                ", memberCode=" + memberCode +
                '}';
    }
}
