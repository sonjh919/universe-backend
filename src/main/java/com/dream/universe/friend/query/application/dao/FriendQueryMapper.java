package com.dream.universe.friend.query.application.dao;

import com.dream.universe.friend.domain.model.Friend;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface FriendQueryMapper {
    Optional<Friend> findByRequest(Long memberCode);
}
