package com.github.blog.controllers.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserControllerResponse {

    private String name;

    private String email;
}
