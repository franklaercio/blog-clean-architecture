package com.github.blog.usecase.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUseCaseResponse {

    private String name;

    private String email;
}
