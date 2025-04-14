package com.packt.blog.service.comment;

import com.packt.blog.dto.CommentRequestDto;
import com.packt.blog.model.Comment;

import java.util.List;

public interface ICommentService {
    Comment createComment(Long articleId, CommentRequestDto dto);

    void deleteComment(Long commentId);

    List<Comment> getAllComments();

    List<Comment> getCommentByArticleId(Long articleId);

    Comment updateComment(Long commentId, CommentRequestDto dto);
}
