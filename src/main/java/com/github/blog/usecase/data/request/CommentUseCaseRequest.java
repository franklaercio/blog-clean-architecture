package com.github.blog.usecase.data.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentUseCaseRequest {

    private String personName;
    private String personEmail;
    private String content;
}
