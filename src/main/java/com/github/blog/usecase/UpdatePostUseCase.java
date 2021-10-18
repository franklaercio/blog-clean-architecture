package com.github.blog.usecase;

import com.github.blog.controllers.data.request.PostControllerRequest;
import com.github.blog.controllers.data.response.PostControllerResponse;

public interface UpdatePostUseCase {

    PostControllerResponse execute(PostControllerRequest postControllerRequest);
}
