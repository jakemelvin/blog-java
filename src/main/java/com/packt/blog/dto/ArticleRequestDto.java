package com.packt.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequestDto {
  @NotEmpty(message = "The title can not be empty")
  private String title;
  @NotEmpty(message = "The content can not be empty")
  private String content;
}
