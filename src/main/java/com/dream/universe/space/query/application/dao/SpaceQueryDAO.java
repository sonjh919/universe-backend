package com.dream.universe.space.query.application.dao;


import com.dream.universe.space.domain.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpaceQueryDAO extends JpaRepository<Space, Long> {
    List<Space> findAllByMemberCode(Long memberCode);

    List<Space> findByspaceNameContains(String spaceName);

    List<Space> findByspaceTag1Contains(String spaceName);

    List<Space> findByspaceTag2Contains(String spaceName);

    List<Space> findByspaceTag3Contains(String spaceName);

//    List<Space> findAllByOrderByLike();
}
