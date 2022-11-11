package com.dream.universe.friend.query.application.service;

import com.dream.universe.friend.command.application.dao.FriendDAO;
import com.dream.universe.friend.domain.model.Friend;
import com.dream.universe.friend.query.application.dao.FriendQueryDAO;
import com.dream.universe.friend.query.application.dao.FriendQueryMapper;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FriendQueryService {

    private final TokenProvider tokenProvider;
    private final MemberMapper memberMapper;
    private final FriendQueryMapper friendQueryMapper;

    public final FriendQueryDAO friendQueryDAO;

    public FriendQueryService(MemberMapper memberMapper, TokenProvider tokenProvider, FriendQueryMapper friendQueryMapper, FriendQueryDAO friendQueryDAO){
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
        this.friendQueryMapper = friendQueryMapper;
        this.friendQueryDAO = friendQueryDAO;
    }

    public List<Friend> findRequestFriendsById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Friend> requestFriend = friendQueryDAO.findAllByMemberCodeAndFriendState(member.getMemberCode(), "request");

        System.out.println(requestFriend);
        return requestFriend;
    }

    public List<Friend> findFriendsById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Friend> requestFriend = friendQueryDAO.findAllByMemberCodeAndFriendState(member.getMemberCode(), "friend");

        System.out.println(requestFriend);
        return requestFriend;
    }

    public Long deleteFriendsByCode(long friendCode) {
        friendQueryDAO.deleteById(friendCode);
        return friendCode;
    }
}
