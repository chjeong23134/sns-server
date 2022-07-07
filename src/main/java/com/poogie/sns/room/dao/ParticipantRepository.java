package com.poogie.sns.room.dao;

import com.poogie.sns.room.domain.ParticipantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends CrudRepository<ParticipantEntity, Long> {
    List<ParticipantEntity> findByUserId(Long userId);
}
