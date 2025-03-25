package com.packt.blog.service.comment;

import com.packt.blog.dto.CommentRequestDto;
import com.packt.blog.model.Comment;

public interface ICommentService {
  Comment createComment(Long articleId, CommentRequestDto dto);

  void deleteComment(Long commentId);
}
