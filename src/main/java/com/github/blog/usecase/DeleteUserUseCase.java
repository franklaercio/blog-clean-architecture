package com.github.blog.usecase;

import com.github.blog.controllers.data.response.UserControllerResponse;
import org.springframework.http.ResponseEntity;

public interface DeleteUserUseCase {

    ResponseEntity<UserControllerResponse> execute(String email);
}
