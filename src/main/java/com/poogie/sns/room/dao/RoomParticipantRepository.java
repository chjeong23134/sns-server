package com.poogie.sns.room.dao;

import com.poogie.sns.room.domain.RoomParticipantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomParticipantRepository extends CrudRepository<RoomParticipantEntity, Long> {
    List<RoomParticipantEntity> findByUserId(Long userId);
}
