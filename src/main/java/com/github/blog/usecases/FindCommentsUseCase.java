package com.github.blog.usecases;

import com.github.blog.controllers.data.response.CommentControllerResponse;
import java.util.List;

public interface FindCommentsUseCase {

    List<CommentControllerResponse> execute();

}
