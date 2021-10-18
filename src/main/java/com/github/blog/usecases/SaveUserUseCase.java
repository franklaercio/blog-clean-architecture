package com.github.blog.usecases;

import com.github.blog.controllers.data.request.UserControllerRequest;
import com.github.blog.controllers.data.response.UserControllerResponse;

public interface SaveUserUseCase {

    UserControllerResponse execute(UserControllerRequest userControllerRequest);
}
