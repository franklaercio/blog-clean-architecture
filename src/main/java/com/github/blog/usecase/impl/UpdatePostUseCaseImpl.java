package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.request.PostControllerRequest;
import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.gateways.PostGateway;
import com.github.blog.usecase.UpdatePostUseCase;
import com.github.blog.usecase.convert.request.PostUseCaseConvertRequest;
import com.github.blog.usecase.convert.response.PostUseCaseConvertResponse;
import com.github.blog.usecase.data.request.PostUseCaseRequest;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePostUseCaseImpl implements UpdatePostUseCase {

    private final PostGateway postGateway;

    private final PostUseCaseConvertRequest postUseCaseConvertRequest;

    private final PostUseCaseConvertResponse postUseCaseConvertResponse;

    @Override
    public PostControllerResponse execute(PostControllerRequest postControllerRequest) {
        PostUseCaseRequest commentUseCaseRequest = this.postUseCaseConvertRequest.convert(
            postControllerRequest);

        PostUseCaseResponse postUseCaseResponse = this.postGateway.saveOrUpdate(
            commentUseCaseRequest);

        return this.postUseCaseConvertResponse.convert(postUseCaseResponse);
    }
}
