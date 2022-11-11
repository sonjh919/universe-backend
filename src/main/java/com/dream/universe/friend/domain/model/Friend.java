package com.dream.universe.friend.domain.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "SEQ_TB_FRIEND_CODE"
        , sequenceName = "SEQ_TB_FRIEND_CODE"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "TB_FRIEND")
public class Friend {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "SEQ_TB_FRIEND_CODE"
    )
    @Column(name="FRIEND_CODE")
    private long friendCode;

    @Column(name="MEMBER_CODE")
    private long memberCode;

    @Column(name="FRIEND_MEMBER_CODE")
    private long friendMemberCode;

    @Column(name="FRIEND_STATE")
    private String friendState;

    public Friend(){}

    public Friend(long friendCode, long memberCode, long friendMemberCode, String friendState) {
        this.friendCode = friendCode;
        this.memberCode = memberCode;
        this.friendMemberCode = friendMemberCode;
        this.friendState = friendState;
    }

    public long getFriendCode() {
        return friendCode;
    }

    public void setFriendCode(long friendCode) {
        this.friendCode = friendCode;
    }

    public long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(long memberCode) {
        this.memberCode = memberCode;
    }

    public long getFriendMemberCode() {
        return friendMemberCode;
    }

    public void setFriendMemberCode(long friendMemberCode) {
        this.friendMemberCode = friendMemberCode;
    }

    public String getFriendState() {
        return friendState;
    }

    public void setFriendState(String friendState) {
        this.friendState = friendState;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friendCode=" + friendCode +
                ", memberCode=" + memberCode +
                ", friendMemberCode=" + friendMemberCode +
                ", friendState='" + friendState + '\'' +
                '}';
    }
}
