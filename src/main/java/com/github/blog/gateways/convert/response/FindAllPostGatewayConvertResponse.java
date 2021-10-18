package com.github.blog.gateways.convert.response;

import com.github.blog.entities.PostEntity;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FindAllPostGatewayConvertResponse implements Converter<Iterable<PostEntity>, List<PostUseCaseResponse>> {

    @Override
    public List<PostUseCaseResponse> convert(Iterable<PostEntity> source) {
        List<PostUseCaseResponse> response = new ArrayList<>();

        source.forEach(post -> response.add(
            PostUseCaseResponse.builder()
                .uuid(post.getId().toString())
                .author(post.getAuthor())
                .title(post.getTitle())
                .subtitle(post.getSubtitle())
                .createdAt(post.getCreatedAt().toLocalDate().toString())
                .build()
        ));

        return response;
    }
}
