package com.poogie.sns.topic.api;

import com.poogie.sns.topic.dao.TopicService;
import com.poogie.sns.topic.domain.TopicEntity;
import com.poogie.sns.topic.dto.TopicRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/topic")
public class TopicController {
    private final TopicService topicService;

    @PostMapping("/create")
    public ResponseEntity<TopicEntity> create(@RequestBody TopicRequestDto.Create req) {
        return new ResponseEntity<>(topicService.add(req), HttpStatus.OK);
    }
}
