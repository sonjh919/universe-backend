package com.dream.universe.bookmark.command.application.dto;

public class BookmarkDTO {
    private long bookmarkCode;
    private long spaceCode;
    private long memberCode;

    public BookmarkDTO(){}

    public BookmarkDTO(long bookmarkCode, long spaceCode, long memberCode) {
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
        return "BookmarkDTO{" +
                "bookmarkCode=" + bookmarkCode +
                ", spaceCode=" + spaceCode +
                ", memberCode=" + memberCode +
                '}';
    }
}
