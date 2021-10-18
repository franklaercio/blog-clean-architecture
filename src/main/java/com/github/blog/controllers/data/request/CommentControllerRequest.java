package com.github.blog.controllers.data.request;

import lombok.Data;

@Data
public class CommentControllerRequest {

    private String personName;
    private String personEmail;
    private String content;
}
