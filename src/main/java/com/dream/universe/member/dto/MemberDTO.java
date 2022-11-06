package com.dream.universe.member.dto;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MemberDTO implements UserDetails{

    private Long memberCode;
    private String email;
    private String password;
    private String memberName;
    private String phoneNumber;
    private Long cap;
    private Long cherry;
    private String nickName;
    private String memberRole;

    public MemberDTO(Long memberCode, String email, String password, String memberName, String phoneNumber, Long cap, Long cherry, String nickName, String memberRole, Collection<? extends GrantedAuthority> authorities) {
        this.memberCode = memberCode;
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.cap = cap;
        this.cherry = cherry;
        this.nickName = nickName;
        this.memberRole = memberRole;
        this.authorities = authorities;
    }

    public MemberDTO() {}

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCap() {
        return cap;
    }

    public void setCap(Long cap) {
        this.cap = cap;
    }

    public Long getCherry() {
        return cherry;
    }

    public void setCherry(Long cherry) {
        this.cherry = cherry;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
    public String getUsername() {
        return this.memberName;
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
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", memberName='" + memberName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cap=" + cap +
                ", cherry=" + cherry +
                ", nickName='" + nickName + '\'' +
                ", memberRole='" + memberRole + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
