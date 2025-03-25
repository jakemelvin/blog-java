package com.packt.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packt.blog.model.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {
  
}
