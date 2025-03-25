package com.packt.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.blog.dto.CommentRequestDto;
import com.packt.blog.response.ApiResponse;
import com.packt.blog.service.comment.ICommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/comments")
@RequiredArgsConstructor
@Validated
@Tag(name = "Comments", description="Api to manage the comments on different articles")
public class CommentController {
  private final ICommentService commentService;

  @PostMapping("/create")
  @Operation(description = "Post endpoint to add a comment to an article")
  public ResponseEntity<ApiResponse> addComment(@RequestParam Long articleId,@Valid @RequestBody CommentRequestDto dto)
      throws Exception {
    return ResponseEntity
        .ok(new ApiResponse("Comment added successfully", commentService.createComment(articleId, dto)));
  }

  @DeleteMapping("/delete")
  @Operation(description = "Delete endpoint to erase an article by his Id ")
  public ResponseEntity<ApiResponse> deleteComment(@RequestParam Long commentId) throws Exception {
    commentService.deleteComment(commentId);
    return ResponseEntity.ok(new ApiResponse("Comment deleted successfully", null));
  }
}
