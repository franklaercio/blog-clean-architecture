package com.github.blog.gateways.convert.request;

import com.github.blog.entities.PostEntity;
import com.github.blog.entities.enums.Status;
import com.github.blog.usecases.data.request.PostUseCaseRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostGatewayConvertRequest implements Converter<PostUseCaseRequest, PostEntity> {

    @Override
    public PostEntity convert(PostUseCaseRequest source) {

        return PostEntity.builder()
            .author(source.getAuthor())
            .title(source.getTitle())
            .subtitle(source.getSubtitle())
            .content(source.getContent())
            .status(Status.AVAILABLE)
            .allowComment(Boolean.TRUE)
            .allowFeed(Boolean.TRUE)
            .allowPing(Boolean.TRUE)
            .build();
    }
}
