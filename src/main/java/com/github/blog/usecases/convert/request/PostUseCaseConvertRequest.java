package com.github.blog.usecases.convert.request;

import com.github.blog.controllers.data.request.PostControllerRequest;
import com.github.blog.usecases.data.request.PostUseCaseRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("PostUseCaseConvertRequest")
public class PostUseCaseConvertRequest implements
    Converter<PostControllerRequest, PostUseCaseRequest> {

    @Override
    public PostUseCaseRequest convert(PostControllerRequest source) {
        return PostUseCaseRequest.builder()
            .author(source.getAuthor())
            .title(source.getTitle())
            .subtitle(source.getSubtitle())
            .content(source.getContent())
            .build();
    }
}
