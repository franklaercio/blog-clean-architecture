package com.github.blog.gateways.convert.response;

import com.github.blog.entities.CommentEntity;
import com.github.blog.usecase.data.response.CommentUseCaseResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("FindAllCommentGatewayResponse")
public class FindAllCommentGatewayConvertResponse implements
    Converter<Iterable<CommentEntity>, List<CommentUseCaseResponse>> {

    @Override
    public List<CommentUseCaseResponse> convert(Iterable<CommentEntity> source) {
        List<CommentUseCaseResponse> commentUseCaseResponses = new ArrayList<>();

        source.forEach(commentEntity -> {
            commentUseCaseResponses.add(
                CommentUseCaseResponse.builder()
                .personName(commentEntity.getPersonName())
                .personEmail(commentEntity.getPersonEmail())
                .content(commentEntity.getContent())
                .build()
            );
        });

        return commentUseCaseResponses;
    }
}
