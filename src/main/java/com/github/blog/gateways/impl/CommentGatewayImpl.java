package com.github.blog.gateways.impl;

import com.github.blog.entities.CommentEntity;
import com.github.blog.gateways.CommentGateway;
import com.github.blog.gateways.convert.request.PublishCommentGatewayConvertRequest;
import com.github.blog.gateways.convert.response.FindAllCommentGatewayConvertResponse;
import com.github.blog.gateways.convert.response.PublishCommentGatewayConvertResponse;
import com.github.blog.gateways.jpa.CommentRepository;
import com.github.blog.usecase.data.request.CommentUseCaseRequest;
import com.github.blog.usecase.data.response.CommentUseCaseResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentGatewayImpl implements CommentGateway {

    private final CommentRepository commentRepository;
    private final PublishCommentGatewayConvertRequest publishCommentGatewayConvertRequest;
    private final PublishCommentGatewayConvertResponse publishCommentGatewayConvertResponse;
    private final FindAllCommentGatewayConvertResponse findAllCommentGatewayConvertResponse;

    @Override
    public CommentUseCaseResponse publishComment(CommentUseCaseRequest commentUseCaseRequest) {
        CommentEntity commentRequest = this.publishCommentGatewayConvertRequest.convert(
            commentUseCaseRequest);

        CommentEntity commentResponse = commentRepository.save(commentRequest);

        return this.publishCommentGatewayConvertResponse.convert(commentResponse);
    }

    @Override
    public List<CommentUseCaseResponse> findAllComments() {
        Iterable<CommentEntity> comments = commentRepository.findAll();

        return this.findAllCommentGatewayConvertResponse.convert(comments);
    }
}
