package com.github.blog.usecase.convert.response;

import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("FindPostsUseCaseConvertResponse")
public class FindPostsUseCaseConvertResponse implements
    Converter<List<PostUseCaseResponse>, List<PostControllerResponse>> {

    @Override
    public List<PostControllerResponse> convert(List<PostUseCaseResponse> source) {
        List<PostControllerResponse> commentControllerResponse = new ArrayList<>();

        source.forEach(postUseCaseResponse -> {
            commentControllerResponse.add(
                PostControllerResponse.builder()
                    .author(postUseCaseResponse.getAuthor())
                    .title(postUseCaseResponse.getTitle())
                    .subtitle(postUseCaseResponse.getSubtitle())
                    .content(postUseCaseResponse.getContent())
                    .build()
            );
        });

        return commentControllerResponse;
    }

}
