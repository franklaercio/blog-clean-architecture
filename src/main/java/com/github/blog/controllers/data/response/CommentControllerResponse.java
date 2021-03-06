package com.github.blog.controllers.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentControllerResponse {

    private String personName;
    private String personEmail;
    private String content;
}
