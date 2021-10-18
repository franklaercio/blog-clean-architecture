package com.github.blog.usecases;

import com.github.blog.controllers.data.request.UserControllerRequest;
import com.github.blog.controllers.data.response.UserControllerResponse;
import org.springframework.http.ResponseEntity;

public interface UpdateUserUseCase {

    UserControllerResponse execute(UserControllerRequest userControllerRequest);
}
