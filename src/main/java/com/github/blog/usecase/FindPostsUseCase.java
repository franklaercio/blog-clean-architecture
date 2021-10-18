package com.github.blog.usecase;

import com.github.blog.controllers.data.response.PostControllerResponse;
import java.util.List;

public interface FindPostsUseCase {

    List<PostControllerResponse> execute();
}
