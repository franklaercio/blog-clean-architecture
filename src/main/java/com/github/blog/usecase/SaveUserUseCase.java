package com.github.blog.usecase;

import com.github.blog.controllers.data.request.UserControllerRequest;
import com.github.blog.controllers.data.response.UserControllerResponse;
import org.springframework.http.ResponseEntity;

public interface SaveUserUseCase {

    ResponseEntity<UserControllerResponse> execute(UserControllerRequest userControllerRequest);
}
