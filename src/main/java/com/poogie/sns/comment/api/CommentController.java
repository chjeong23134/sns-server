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
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentEntity> create(@RequestBody CommentRequestDto.Create req) {
        return new ResponseEntity<>(commentService.add(req), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CommentEntity>> list(@RequestParam Long topicId) {
        return new ResponseEntity<>(commentService.findByTopicId(topicId), HttpStatus.OK);
    }
}
