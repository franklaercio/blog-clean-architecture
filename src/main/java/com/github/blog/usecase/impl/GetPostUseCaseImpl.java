package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.gateways.PostGateway;
import com.github.blog.usecase.GetPostUseCase;
import com.github.blog.usecase.convert.response.PostUseCaseConvertResponse;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPostUseCaseImpl implements GetPostUseCase {

    private final PostGateway postGateway;

    private final PostUseCaseConvertResponse postUseCaseConvertResponse;

    @Override
    public PostControllerResponse execute(String title) {
        PostUseCaseResponse postUseCaseResponse = this.postGateway.find(title);
        return this.postUseCaseConvertResponse.convert(postUseCaseResponse);
    }
}
