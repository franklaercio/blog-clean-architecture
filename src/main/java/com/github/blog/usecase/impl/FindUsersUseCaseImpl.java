package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.response.UserControllerResponse;
import com.github.blog.gateways.UserGateway;
import com.github.blog.usecase.FindUsersUseCase;
import com.github.blog.usecase.convert.response.UserUseCaseConvertResponse;
import com.github.blog.usecase.data.response.UserUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUsersUseCaseImpl implements FindUsersUseCase {

    private final UserGateway userGateway;

    private final UserUseCaseConvertResponse userUseCaseConvertResponse;

    @Override
    public ResponseEntity<UserControllerResponse> execute(String email) {
        UserUseCaseResponse userUseCaseResponse = this.userGateway.findUser(email);
        return ResponseEntity.ok(this.userUseCaseConvertResponse.convert(userUseCaseResponse));
    }
}
