package com.github.blog.usecases.impl;

import com.github.blog.controllers.data.request.UserControllerRequest;
import com.github.blog.controllers.data.response.UserControllerResponse;
import com.github.blog.gateways.UserGateway;
import com.github.blog.usecases.UpdateUserUseCase;
import com.github.blog.usecases.convert.request.UserUseCaseConvertRequest;
import com.github.blog.usecases.convert.response.UserUseCaseConvertResponse;
import com.github.blog.usecases.data.request.UserUseCaseRequest;
import com.github.blog.usecases.data.response.UserUseCaseResponse;
import com.github.blog.usecases.exceptions.InternalServerErrorException;
import com.github.blog.usecases.utils.ValidationUtils;
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
        ValidationUtils.isUserValid(userControllerRequest);

        try{
            UserUseCaseRequest userUseCaseRequest = this.userUseCaseConvertRequest.convert(
                userControllerRequest);

            UserUseCaseResponse userUseCaseResponse = this.userGateway.saveOrUpdate(
                userUseCaseRequest);

            return ResponseEntity.ok(this.userUseCaseConvertResponse.convert(userUseCaseResponse));
        } catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
