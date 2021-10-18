package com.github.blog.usecase;

import com.github.blog.controllers.data.response.PostControllerResponse;

public interface GetPostUseCase {

    PostControllerResponse execute(String title);
}
