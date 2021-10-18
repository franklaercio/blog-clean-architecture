package com.github.blog.controllers.data.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserControllerRequest {

    private String name;

    private String email;

    private String username;

    private String password;
}
