package com.packt.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@Tag(name = "Comments", description = "Api to manage the comments on different articles")
public class CommentController {
    private final ICommentService commentService;

    @PostMapping("/create")
    @Operation(description = "Post endpoint to add a comment to an article")
    public ResponseEntity<ApiResponse> addComment(@RequestParam Long articleId, @Valid @RequestBody CommentRequestDto dto)
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

    @GetMapping
    @Operation(description = "Get endpoint to get all the comments")
    public ResponseEntity<ApiResponse> getAllComments() throws Exception {
        return ResponseEntity.ok(new ApiResponse("All comments fetched!", commentService.getAllComments()));
    }

    @GetMapping("/get-by")
    @Operation(description = "Get endpoint to get all the comments of an article")
    public ResponseEntity<ApiResponse> getComment(@RequestParam Long articleId) throws Exception {
        return ResponseEntity.ok(new ApiResponse("Comments of the article fetched successfully", commentService.getCommentByArticleId(articleId)));
    }

    @PutMapping
    @Operation(description = "Put endpoint to update a comment")
    public ResponseEntity<ApiResponse> updateComment(@RequestParam Long commentId, @RequestBody CommentRequestDto dto) throws Exception {
        return ResponseEntity.ok(new ApiResponse("Comment updated successfully", commentService.updateComment(commentId, dto)));
    }
}
