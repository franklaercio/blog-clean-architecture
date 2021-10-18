package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.gateways.PostGateway;
import com.github.blog.usecase.DeletePostUseCase;
import com.github.blog.usecase.convert.response.PostUseCaseConvertResponse;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostUseCaseImpl implements DeletePostUseCase {

    private final PostGateway postGateway;

    private final PostUseCaseConvertResponse postUseCaseConvertResponse;

    @Override
    public PostControllerResponse execute(String uuid) {
        PostUseCaseResponse postUseCaseResponse = this.postGateway.delete(uuid);
        return this.postUseCaseConvertResponse.convert(postUseCaseResponse);
    }
}
