package com.github.blog.controllers.data.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentControllerRequest {

    private String personName;
    private String personEmail;
    private String content;
}
