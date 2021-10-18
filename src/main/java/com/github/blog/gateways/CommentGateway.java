package com.github.blog.gateways;

import com.github.blog.usecases.data.request.CommentUseCaseRequest;
import com.github.blog.usecases.data.response.CommentUseCaseResponse;
import java.util.List;

public interface CommentGateway {

    CommentUseCaseResponse publishComment(CommentUseCaseRequest commentUseCaseRequest);

    List<CommentUseCaseResponse> findAllComments();
}
