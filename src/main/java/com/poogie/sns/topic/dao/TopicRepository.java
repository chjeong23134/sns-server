package com.poogie.sns.topic.dao;

import com.poogie.sns.topic.domain.TopicEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<TopicEntity, Long> {
    List<TopicEntity> findByRoomId(Long roomId);
}
