package com.github.blog.usecase.data.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostUseCaseRequest {

    private String author;

    private String title;

    private String subtitle;

    private String content;
}
