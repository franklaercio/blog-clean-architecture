package com.github.blog.usecase.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentUseCaseResponse {

    private String personName;
    private String personEmail;
    private String content;
}
