package com.github.blog.usecases.convert.response;

import com.github.blog.controllers.data.response.CommentControllerResponse;
import com.github.blog.usecases.data.response.CommentUseCaseResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("CommentUseCaseConvertResponse")
public class CommentUseCaseConvertResponse implements
    Converter<CommentUseCaseResponse, CommentControllerResponse> {

    @Override
    public CommentControllerResponse convert(CommentUseCaseResponse source) {
        return CommentControllerResponse.builder()
            .personName(source.getPersonName())
            .personEmail(source.getPersonEmail())
            .content(source.getContent())
            .build();
    }
}
