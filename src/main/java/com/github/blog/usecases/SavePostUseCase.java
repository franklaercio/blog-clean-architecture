package com.github.blog.usecases;

import com.github.blog.controllers.data.request.PostControllerRequest;
import com.github.blog.controllers.data.response.PostControllerResponse;

public interface SavePostUseCase {

    PostControllerResponse execute(PostControllerRequest postControllerRequest);
}
