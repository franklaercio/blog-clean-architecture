package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.response.CommentControllerResponse;
import com.github.blog.gateways.CommentGateway;
import com.github.blog.usecase.FindCommentsUseCase;
import com.github.blog.usecase.convert.response.FindCommentsUseCaseConvertResponse;
import com.github.blog.usecase.data.response.CommentUseCaseResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCommentsUseCaseImpl implements FindCommentsUseCase {

    private final CommentGateway commentGateway;

    private final FindCommentsUseCaseConvertResponse commentUseCaseConvertResponse;

    @Override
    public List<CommentControllerResponse> execute() {
        List<CommentUseCaseResponse> commentUseCaseResponses = this.commentGateway.findAllComments();
        return this.commentUseCaseConvertResponse.convert(commentUseCaseResponses);
    }
}
