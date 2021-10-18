package com.github.blog.usecases.impl;

import com.github.blog.controllers.data.response.UserControllerResponse;
import com.github.blog.gateways.UserGateway;
import com.github.blog.usecases.FindUsersUseCase;
import com.github.blog.usecases.convert.response.UserUseCaseConvertResponse;
import com.github.blog.usecases.data.response.UserUseCaseResponse;
import com.github.blog.usecases.exceptions.InternalServerErrorException;
import com.github.blog.usecases.exceptions.NotFoundErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUsersUseCaseImpl implements FindUsersUseCase {

    private final UserGateway userGateway;

    private final UserUseCaseConvertResponse userUseCaseConvertResponse;

    @Override
    public UserControllerResponse execute(String email) {
        try{
            UserUseCaseResponse userUseCaseResponse = this.userGateway.findUser(email);

            if (userUseCaseResponse == null) {
                throw new NotFoundErrorException();
            }

            return this.userUseCaseConvertResponse.convert(userUseCaseResponse);
        } catch (NotFoundErrorException ex) {
            throw new NotFoundErrorException("Não foi possível encontrar nenhum usuário.");
        } catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
