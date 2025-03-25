package com.packt.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.blog.dto.ArticleRequestDto;

import com.packt.blog.service.article.IArticleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.packt.blog.response.ApiResponse;

@RestController
@RequestMapping("${api.prefix}/articles")
@RequiredArgsConstructor
@Validated
@Tag(name = "Articles", description = "Api to manage articles from creation, update to deletion")
public class ArticleController {
  private final IArticleService articleService;

  @PostMapping("/create")
  @Operation(description = "Post endpoint to create artciles")
  public ResponseEntity<ApiResponse> createArticle(@Valid @RequestBody ArticleRequestDto dto) throws Exception {
    return ResponseEntity.ok(new ApiResponse("Article created successfully", articleService.createArticle(dto)));
  }

  @GetMapping
  @Operation(description = "Get endpoint to retrieve all the articles")
  public ResponseEntity<ApiResponse> getAllArticles() {
    return ResponseEntity.ok(new ApiResponse("Articles fetched successfully", articleService.getAllArticles()));
  }

  @GetMapping("/get-by")
  @Operation(description = "Get endpoint to retrieve an article by his Id")
  public ResponseEntity<ApiResponse> getArticleById(@RequestParam Long articleId) throws Exception {
    return ResponseEntity.ok(new ApiResponse("Article found", articleService.getArticleById(articleId)));
  }

  @DeleteMapping("/delete")
  @Operation(description = "Delete endpoint to erase an artcile by his Id")
  public ResponseEntity<ApiResponse> deleteArticle(@RequestParam Long articleId) throws Exception {
    articleService.deleteArticle(articleId);
    return ResponseEntity.ok(new ApiResponse("Article deleted successfully", null));
  }

  @PutMapping("/update")
  @Operation(description = "Put endpoint to update an artcile by using his ID and and a custom dto")
  public ResponseEntity<ApiResponse> updateArticle(@RequestParam Long articleId,
      @Valid @RequestBody ArticleRequestDto dto) throws Exception {
    return ResponseEntity
        .ok(new ApiResponse("Article updated successfully", articleService.updateArticle(articleId, dto)));
  }

}
