package com.github.blog.gateways.convert.response;

import com.github.blog.entities.CommentEntity;
import com.github.blog.usecases.data.response.CommentUseCaseResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("PublishCommentGatewayConvertResponse")
public class PublishCommentGatewayConvertResponse implements
    Converter<CommentEntity, CommentUseCaseResponse> {

    @Override
    public CommentUseCaseResponse convert(CommentEntity source) {
        return CommentUseCaseResponse.builder()
            .personName(source.getPersonName())
            .personEmail(source.getPersonEmail())
            .content(source.getContent())
            .build();
    }
}
