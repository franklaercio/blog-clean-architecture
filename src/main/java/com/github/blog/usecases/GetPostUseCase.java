package com.github.blog.usecases;

import com.github.blog.controllers.data.response.PostControllerResponse;

public interface GetPostUseCase {

    PostControllerResponse execute(String title);
}
