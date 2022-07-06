package com.poogie.sns.comment.dao;

import com.poogie.sns.comment.domain.CommentEntity;
import com.poogie.sns.comment.dto.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentEntity add(CommentRequestDto.Create req) {
        return commentRepository.save(req.toEntity());
    }
}
