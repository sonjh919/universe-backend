package com.dream.universe.member.dto;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MemberDTO implements UserDetails{

    private Long memberCode;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberPhone;
    private Long memberCap;
    private Long memberCherry;
    private String memberNickName;
    private String memberRole;

    private String memberMajor;

    private String memberWithdrawal;

    public MemberDTO(Long memberCode, String memberEmail, String memberPassword, String memberName, String memberPhone, Long memberCap, Long memberCherry, String memberNickName, String memberRole, String memberMajor, String memberWithdrawal, Collection<? extends GrantedAuthority> authorities) {
        this.memberCode = memberCode;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberCap = memberCap;
        this.memberCherry = memberCherry;
        this.memberNickName = memberNickName;
        this.memberRole = memberRole;
        this.memberMajor = memberMajor;
        this.memberWithdrawal = memberWithdrawal;
        this.authorities = authorities;
    }

    public MemberDTO() {}

    public String getMemberWithdrawal() {
        return memberWithdrawal;
    }

    public void setMemberWithdrawal(String memberWithdrawal) {
        this.memberWithdrawal = memberWithdrawal;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Long getMemberCap() {
        return memberCap;
    }

    public void setMemberCap(Long memberCap) {
        this.memberCap = memberCap;
    }

    public Long getMemberCherry() {
        return memberCherry;
    }

    public void setMemberCherry(Long memberCherry) {
        this.memberCherry = memberCherry;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberMajor() {
        return memberMajor;
    }

    public void setMemberMajor(String memberMajor) {
        this.memberMajor = memberMajor;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.getMemberPassword();
    }

    @Override
    public String getUsername() {
        return this.getMemberName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", memberCap=" + memberCap +
                ", memberCherry=" + memberCherry +
                ", memberNickName='" + memberNickName + '\'' +
                ", memberRole='" + memberRole + '\'' +
                ", memberMajor='" + memberMajor + '\'' +
                ", memberWithdrawal='" + memberWithdrawal + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
