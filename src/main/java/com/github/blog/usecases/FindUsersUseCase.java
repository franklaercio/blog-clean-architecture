package com.github.blog.usecases;

import com.github.blog.controllers.data.response.UserControllerResponse;
import org.springframework.http.ResponseEntity;

public interface FindUsersUseCase {

    UserControllerResponse execute(String email);
}
