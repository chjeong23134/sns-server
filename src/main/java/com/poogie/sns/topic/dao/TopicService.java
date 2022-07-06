package com.poogie.sns.topic.dao;

import com.poogie.sns.topic.domain.TopicEntity;
import com.poogie.sns.topic.dto.TopicRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicEntity add(TopicRequestDto.Create req) {
        return topicRepository.save(req.toEntity());
    }
}
