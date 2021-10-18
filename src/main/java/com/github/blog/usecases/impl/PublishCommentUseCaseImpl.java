package com.github.blog.usecases.impl;

import com.github.blog.controllers.data.request.CommentControllerRequest;
import com.github.blog.controllers.data.response.CommentControllerResponse;
import com.github.blog.gateways.CommentGateway;
import com.github.blog.usecases.PublishCommentUseCase;
import com.github.blog.usecases.convert.request.CommentUseCaseConvertRequest;
import com.github.blog.usecases.convert.response.CommentUseCaseConvertResponse;
import com.github.blog.usecases.data.request.CommentUseCaseRequest;
import com.github.blog.usecases.data.response.CommentUseCaseResponse;
import com.github.blog.usecases.exceptions.InternalServerErrorException;
import com.github.blog.usecases.utils.ValidationUtils;
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
        ValidationUtils.isCommentValid(commentControllerRequest);

        try{
            CommentUseCaseRequest commentUseCaseRequest = commentUseCaseConvertRequest.convert(
                commentControllerRequest);

            CommentUseCaseResponse commentUseCaseResponse = this.commentGateway.publishComment(
                commentUseCaseRequest);

            return this.commentUseCaseConvertResponse.convert(commentUseCaseResponse);
        } catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
