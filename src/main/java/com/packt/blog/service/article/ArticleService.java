package com.packt.blog.service.article;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.packt.blog.dto.ArticleRequestDto;
import com.packt.blog.exceptions.ResourceNotFoundException;
import com.packt.blog.mapper.ArticleMapper;
import com.packt.blog.model.Article;
import com.packt.blog.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {
  private final ArticleRepository articleRepository;

  @Override
  public Article createArticle(ArticleRequestDto dto) {
    return articleRepository.save(ArticleMapper.toEntity(dto));
  }

  @Override
  public List<Article> getAllArticles() {
    return articleRepository.findAll();
  }

  @Override
  public Article getArticleById(Long id) {
    return articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found!"));
  }

  @Override
  public Article updateArticle(Long articleId, ArticleRequestDto dto) {
    Article articleToUpdate = articleRepository.findById(articleId)
        .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    articleToUpdate.setTitle(dto.getTitle());
    articleToUpdate.setContent(dto.getContent());
    articleToUpdate.setUpdatedAt(LocalDate.now());
    return articleRepository.save(articleToUpdate);
  }

  @Override
  public void deleteArticle(Long articleId) {
    Article articleToDelete = articleRepository.findById(articleId)
        .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    articleRepository.delete(articleToDelete);
  }

}
