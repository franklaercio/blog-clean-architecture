package com.github.blog.usecase.convert.response;

import com.github.blog.controllers.data.response.CommentControllerResponse;
import com.github.blog.usecase.data.response.CommentUseCaseResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("FindCommentsUseCaseConvertResponse")
public class FindCommentsUseCaseConvertResponse implements
    Converter<List<CommentUseCaseResponse>, List<CommentControllerResponse>> {

    @Override
    public List<CommentControllerResponse> convert(List<CommentUseCaseResponse> source) {
        List<CommentControllerResponse> commentControllerResponse = new ArrayList<>();

        source.forEach(commentUseCaseResponse -> {
            commentControllerResponse.add(
                CommentControllerResponse.builder()
                    .personName(commentUseCaseResponse.getPersonName())
                    .personEmail(commentUseCaseResponse.getPersonEmail())
                    .content(commentUseCaseResponse.getContent())
                    .build()
            );
        });

        return commentControllerResponse;
    }

}
