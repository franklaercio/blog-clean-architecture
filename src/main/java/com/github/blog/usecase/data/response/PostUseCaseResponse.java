package com.github.blog.usecase.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostUseCaseResponse {

    private String uuid;

    private String author;

    private String title;

    private String subtitle;

    private String content;

    private String createdAt;
}
