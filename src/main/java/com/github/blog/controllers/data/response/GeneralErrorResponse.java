package com.github.blog.controllers.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralErrorResponse {

    private int code;

    private String description;

    private String message;
}
