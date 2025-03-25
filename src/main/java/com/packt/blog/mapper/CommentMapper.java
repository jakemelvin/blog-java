package com.packt.blog.mapper;

import com.packt.blog.dto.CommentRequestDto;
import com.packt.blog.model.Article;
import com.packt.blog.model.Comment;

public class CommentMapper {
  public static Comment toEntity(CommentRequestDto dto, Article article) {
    Comment newComment = new Comment();
    newComment.setArticle(article);
    newComment.setContent(dto.getContent());
    return newComment;
  }
}
