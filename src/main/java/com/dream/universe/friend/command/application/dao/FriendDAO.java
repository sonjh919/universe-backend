package com.dream.universe.friend.command.application.dao;

import com.dream.universe.friend.domain.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendDAO extends JpaRepository<Friend, Long>{

}
