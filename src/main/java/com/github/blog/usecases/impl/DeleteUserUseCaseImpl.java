package com.github.blog.usecases.impl;

import com.github.blog.gateways.UserGateway;
import com.github.blog.usecases.DeleteUserUseCase;
import com.github.blog.usecases.exceptions.BadRequestErrorException;
import com.github.blog.usecases.exceptions.InternalServerErrorException;
import com.github.blog.usecases.exceptions.NotFoundErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserGateway userGateway;

    @Override
    public void execute(String email) {
        try {
            if(email == null || email.isBlank()) {
                throw new BadRequestErrorException("E-mail do Usuário não foi informado.");
            }

            boolean isDeleted = this.userGateway.deleteUser(email);

            if (!isDeleted) {
                throw new NotFoundErrorException("E-mail do Usuário é inválido.");
            }
        } catch (BadRequestErrorException ex) {
            throw new BadRequestErrorException("E-mail do Usuário não foi informado.");
        } catch (NotFoundErrorException ex) {
            throw new NotFoundErrorException("E-mail do Usuário é inválido.");
        } catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
