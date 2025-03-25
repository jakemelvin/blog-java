package com.packt.blog.service.comment;

import org.springframework.stereotype.Service;

import com.packt.blog.dto.CommentRequestDto;
import com.packt.blog.exceptions.ResourceNotFoundException;
import com.packt.blog.mapper.CommentMapper;
import com.packt.blog.model.Article;
import com.packt.blog.model.Comment;
import com.packt.blog.repository.ArticleRepository;
import com.packt.blog.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {
  private final CommentRepository commentRepository;
  private final ArticleRepository articleRepository;

  @Override
  public Comment createComment(Long articleId, CommentRequestDto dto) {
    Article articleLinked = articleRepository.findById(articleId)
        .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    return commentRepository.save(CommentMapper.toEntity(dto, articleLinked));
  }

  @Override
  public void deleteComment(Long commentId) {
    Comment commentToDelete = commentRepository.findById(commentId)
        .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    commentRepository.delete(commentToDelete);
  }

}
