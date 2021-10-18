package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.request.CommentControllerRequest;
import com.github.blog.controllers.data.response.CommentControllerResponse;
import com.github.blog.gateways.CommentGateway;
import com.github.blog.usecase.PublishCommentUseCase;
import com.github.blog.usecase.convert.request.CommentUseCaseConvertRequest;
import com.github.blog.usecase.convert.response.CommentUseCaseConvertResponse;
import com.github.blog.usecase.data.request.CommentUseCaseRequest;
import com.github.blog.usecase.data.response.CommentUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishCommentUseCaseImpl implements PublishCommentUseCase {

    private final CommentGateway commentGateway;

    private final CommentUseCaseConvertRequest commentUseCaseConvertRequest;

    private final CommentUseCaseConvertResponse commentUseCaseConvertResponse;

    @Override
    public CommentControllerResponse execute(CommentControllerRequest commentControllerRequest) {
        CommentUseCaseRequest commentUseCaseRequest = commentUseCaseConvertRequest.convert(
            commentControllerRequest);

        CommentUseCaseResponse commentUseCaseResponse = this.commentGateway.publishComment(
            commentUseCaseRequest);

        return this.commentUseCaseConvertResponse.convert(commentUseCaseResponse);
    }
}
