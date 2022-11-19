package com.dream.universe.friend.query.application.dao;

import com.dream.universe.friend.domain.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendQueryDAO extends JpaRepository<Friend, Long>{

//    Iterable<Friend> findAllByFriendState(String friendState);
//    Iterable<Friend> findAllByMemberCode(Long memberCode);
      List<Friend> findAllByFriendMemberCodeAndFriendState(Long memberCode, String friendState);

//    List<Long> findAllById(Long memberId);
//
//    Iterable<Friend> findAll(Long memberId);
}
