package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.request.UserControllerRequest;
import com.github.blog.controllers.data.response.UserControllerResponse;
import com.github.blog.gateways.UserGateway;
import com.github.blog.usecase.UpdateUserUseCase;
import com.github.blog.usecase.convert.request.UserUseCaseConvertRequest;
import com.github.blog.usecase.convert.response.UserUseCaseConvertResponse;
import com.github.blog.usecase.data.request.UserUseCaseRequest;
import com.github.blog.usecase.data.response.UserUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserGateway userGateway;

    private final UserUseCaseConvertRequest userUseCaseConvertRequest;

    private final UserUseCaseConvertResponse userUseCaseConvertResponse;

    @Override
    public ResponseEntity<UserControllerResponse> execute(
        UserControllerRequest userControllerRequest) {

        UserUseCaseRequest userUseCaseRequest = this.userUseCaseConvertRequest.convert(
            userControllerRequest);

        UserUseCaseResponse userUseCaseResponse = this.userGateway.saveOrUpdate(
            userUseCaseRequest);

        return ResponseEntity.ok(this.userUseCaseConvertResponse.convert(userUseCaseResponse));
    }
}