package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.response.UserControllerResponse;
import com.github.blog.gateways.UserGateway;
import com.github.blog.usecase.DeleteUserUseCase;
import com.github.blog.usecase.convert.response.UserUseCaseConvertResponse;
import com.github.blog.usecase.data.response.UserUseCaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserGateway userGateway;

    private final UserUseCaseConvertResponse userUseCaseConvertResponse;

    @Override
    public ResponseEntity<UserControllerResponse> execute(String email) {
        UserUseCaseResponse userUseCaseResponse = this.userGateway.deleteUser(email);
        return ResponseEntity.ok(this.userUseCaseConvertResponse.convert(userUseCaseResponse));
    }
}
