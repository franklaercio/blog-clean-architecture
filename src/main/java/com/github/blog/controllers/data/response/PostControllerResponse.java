package com.github.blog.controllers.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostControllerResponse {

    private String uuid;

    private String author;

    private String title;

    private String subtitle;

    private String content;

    private String createdAt;
}
