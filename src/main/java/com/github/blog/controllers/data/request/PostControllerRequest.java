package com.github.blog.controllers.data.request;

import lombok.Data;

@Data
public class PostControllerRequest {

    private String author;

    private String title;

    private String subtitle;

    private String content;
}
