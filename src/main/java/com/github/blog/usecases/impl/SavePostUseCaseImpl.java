package com.github.blog.usecases.impl;

import com.github.blog.controllers.data.request.PostControllerRequest;
import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.gateways.PostGateway;
import com.github.blog.usecases.SavePostUseCase;
import com.github.blog.usecases.convert.request.PostUseCaseConvertRequest;
import com.github.blog.usecases.convert.response.PostUseCaseConvertResponse;
import com.github.blog.usecases.data.request.PostUseCaseRequest;
import com.github.blog.usecases.data.response.PostUseCaseResponse;
import com.github.blog.usecases.exceptions.InternalServerErrorException;
import com.github.blog.usecases.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePostUseCaseImpl implements SavePostUseCase {

    private final PostGateway postGateway;

    private final PostUseCaseConvertRequest postUseCaseConvertRequest;

    private final PostUseCaseConvertResponse postUseCaseConvertResponse;

    @Override
    public PostControllerResponse execute(PostControllerRequest postControllerRequest) {
        ValidationUtils.isPostValid(postControllerRequest);

        try{
            PostUseCaseRequest commentUseCaseRequest = this.postUseCaseConvertRequest.convert(
                postControllerRequest);

            PostUseCaseResponse postUseCaseResponse = this.postGateway.saveOrUpdate(
                commentUseCaseRequest);

            return this.postUseCaseConvertResponse.convert(postUseCaseResponse);
        } catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
