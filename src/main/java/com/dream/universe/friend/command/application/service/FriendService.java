package com.dream.universe.friend.command.application.service;

import com.dream.universe.friend.command.application.dao.FriendDAO;
import com.dream.universe.friend.command.application.dto.FriendDTO;
import com.dream.universe.friend.domain.model.Friend;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FriendService {

    public final FriendDAO friendDAO;

    private final MemberMapper memberMapper;
    public final TokenProvider tokenProvider;

    public FriendService(FriendDAO friendDAO, MemberMapper memberMapper, TokenProvider tokenProvider) {
        this.friendDAO = friendDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public Long request(String accessToken, MemberDTO memberDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO sender = memberMapper.findById(memberId);
        MemberDTO reciever = memberMapper.findById(memberDTO.getMemberEmail());

        Friend friend = new Friend();
        friend.setMemberCode(sender.getMemberCode());
        friend.setFriendMemberCode(reciever.getMemberCode());
        friend.setFriendState("request");

        friendDAO.save(friend);

        return friend.getFriendCode();
    }

    public long result(FriendDTO friendDTO) {
        Optional<Friend> oFriend = friendDAO.findById(friendDTO.getFriendCode());

        Friend friend = oFriend.get();
        friend.setFriendState(friendDTO.getFriendState());

        System.out.println(friend.getFriendState());
        if(friend.getFriendState().equals("reject")) {
            System.out.println("reject");
            friendDAO.deleteById(friendDTO.getFriendCode());
            return -1;
        }

        Friend friend2 = new Friend();
        friend2.setMemberCode(friend.getFriendMemberCode());
        friend2.setFriendMemberCode(friend.getMemberCode());
        friend2.setFriendState("friend");

        friendDAO.save(friend);
        friendDAO.save(friend2);

        return friend.getFriendCode();

    }
}
