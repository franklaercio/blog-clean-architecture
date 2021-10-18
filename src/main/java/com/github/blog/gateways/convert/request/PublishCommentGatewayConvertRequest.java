package com.github.blog.gateways.convert.request;

import com.github.blog.entities.CommentEntity;
import com.github.blog.usecases.data.request.CommentUseCaseRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("PublishCommentGatewayConvertRequest")
public class PublishCommentGatewayConvertRequest implements
    Converter<CommentUseCaseRequest, CommentEntity> {

    @Override
    public CommentEntity convert(CommentUseCaseRequest source) {
        return CommentEntity.builder()
            .personName(source.getPersonName())
            .personEmail(source.getPersonEmail())
            .content(source.getContent())
            .build();
    }
}
