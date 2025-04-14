package com.packt.blog.repository;

import com.packt.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import com.packt.blog.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticle(Article article);
}
