package com.packt.blog.mapper;

import java.time.LocalDate;

import com.packt.blog.dto.ArticleRequestDto;
import com.packt.blog.model.Article;

public class ArticleMapper {
  public static Article toEntity(ArticleRequestDto dto) {
    Article article = new Article();
    article.setContent(dto.getContent());
    article.setCreatedAt(LocalDate.now());
    article.setTitle(dto.getTitle());
    return article;
  }
}
