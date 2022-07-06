package com.poogie.sns.comment.api;

import com.poogie.sns.comment.dao.CommentService;
import com.poogie.sns.comment.domain.CommentEntity;
import com.poogie.sns.comment.dto.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<CommentEntity> create(@RequestBody CommentRequestDto.Create req) {
        return new ResponseEntity<>(commentService.add(req), HttpStatus.OK);
    }

    @GetMapping("/list/{topicId}")
    public ResponseEntity<List<CommentEntity>> list(@PathVariable Long topicId) {
        return new ResponseEntity<>(commentService.findByTopicId(topicId), HttpStatus.OK);
    }
}
