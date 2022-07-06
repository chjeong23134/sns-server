package com.poogie.sns.topic.dao;

import com.poogie.sns.topic.domain.TopicEntity;
import com.poogie.sns.topic.dto.TopicRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicEntity add(TopicRequestDto.Create req) {
        return topicRepository.save(req.toEntity());
    }

    public List<TopicEntity> findByRoomId(Long roomId) {
        return topicRepository.findByRoomId(roomId);
    }

    public TopicEntity findById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(null);
    }

    public TopicEntity update(TopicRequestDto.Update req) {
        TopicEntity topic = topicRepository.findById(req.getId())
                .orElseThrow(null);

        topic.update(req.getContent());

        return topicRepository.save(topic);
    }
}
