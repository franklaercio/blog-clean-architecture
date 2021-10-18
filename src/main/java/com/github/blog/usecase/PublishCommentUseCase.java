package com.github.blog.usecase;

import com.github.blog.controllers.data.request.CommentControllerRequest;
import com.github.blog.controllers.data.response.CommentControllerResponse;

public interface PublishCommentUseCase {

    CommentControllerResponse execute(CommentControllerRequest commentControllerRequest);

}
