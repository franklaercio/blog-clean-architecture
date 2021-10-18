package com.github.blog.usecase.convert.response;

import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("PostUseCaseConvertResponse")
public class PostUseCaseConvertResponse implements
    Converter<PostUseCaseResponse, PostControllerResponse> {

    @Override
    public PostControllerResponse convert(PostUseCaseResponse source) {
        return PostControllerResponse.builder()
            .author(source.getAuthor())
            .title(source.getTitle())
            .subtitle(source.getSubtitle())
            .content(source.getContent())
            .build();
    }
}
