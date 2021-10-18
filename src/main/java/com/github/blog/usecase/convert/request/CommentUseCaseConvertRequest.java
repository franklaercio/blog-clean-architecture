package com.github.blog.usecase.convert.request;

import com.github.blog.controllers.data.request.CommentControllerRequest;
import com.github.blog.usecase.data.request.CommentUseCaseRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("CommentUseCaseConvertRequest")
public class CommentUseCaseConvertRequest implements
    Converter<CommentControllerRequest, CommentUseCaseRequest> {

    @Override
    public CommentUseCaseRequest convert(CommentControllerRequest source) {
        return CommentUseCaseRequest.builder()
            .personName(source.getPersonName())
            .personEmail(source.getPersonEmail())
            .content(source.getContent())
            .build();
    }
}
