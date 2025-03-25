package com.packt.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packt.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
