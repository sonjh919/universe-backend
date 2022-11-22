package com.dream.universe.bookmark.domain.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "SEQ_TB_BOOKMARK_CODE"
        , sequenceName = "SEQ_TB_BOOKMARK_CODE"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_BOOKMARK")
public class Bookmark {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "SEQ_TB_BOOKMARK_CODE"
    )

    @Column(name="BOOKMARK_CODE")
    private long bookmarkCode;

    @Column(name="SPACE_CODE")
    private long spaceCode;

    @Column(name="MEMBER_CODE")
    private long memberCode;

    public Bookmark(){}

    public Bookmark(long bookmarkCode, long spaceCode, long memberCode) {
        this.bookmarkCode = bookmarkCode;
        this.spaceCode = spaceCode;
        this.memberCode = memberCode;
    }

    public long getBookmarkCode() {
        return bookmarkCode;
    }

    public void setBookmarkCode(long bookmarkCode) {
        this.bookmarkCode = bookmarkCode;
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
        return "Bookmark{" +
                "bookmarkCode=" + bookmarkCode +
                ", spaceCode=" + spaceCode +
                ", memberCode=" + memberCode +
                '}';
    }
}
