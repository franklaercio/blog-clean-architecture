package com.github.blog.controllers.data.request;

import lombok.Data;

@Data
public class UserControllerRequest {

    private String name;

    private String email;

    private String username;

    private String password;
}
