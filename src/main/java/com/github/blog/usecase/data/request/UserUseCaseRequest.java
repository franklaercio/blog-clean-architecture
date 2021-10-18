package com.github.blog.usecase.data.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUseCaseRequest {

    private String name;

    private String email;

    private String username;

    private String password;
}
