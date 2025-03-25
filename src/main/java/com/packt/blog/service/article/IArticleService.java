package com.packt.blog.service.article;

import java.util.List;

import com.packt.blog.dto.ArticleRequestDto;
import com.packt.blog.model.Article;

public interface IArticleService {
  Article createArticle(ArticleRequestDto dto);

  List<Article> getAllArticles();

  Article getArticleById(Long id);

  Article updateArticle(Long articleId, ArticleRequestDto dto);

  void deleteArticle(Long articleId);
}
