package com.github.blog.gateways.convert.response;

import com.github.blog.entities.PostEntity;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostGatewayConvertResponse implements Converter<PostEntity, PostUseCaseResponse> {

    @Override
    public PostUseCaseResponse convert(PostEntity source) {
        return PostUseCaseResponse.builder()
            .uuid(source.getId().toString())
            .author(source.getAuthor())
            .title(source.getTitle())
            .subtitle(source.getSubtitle())
            .content(source.getContent())
            .createdAt(source.getCreatedAt().toLocalDate().toString())
            .build();
    }
}
