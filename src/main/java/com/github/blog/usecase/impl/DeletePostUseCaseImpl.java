package com.github.blog.usecase.impl;

import com.github.blog.gateways.PostGateway;
import com.github.blog.usecase.DeletePostUseCase;
import com.github.blog.usecase.exceptions.BadRequestErrorException;
import com.github.blog.usecase.exceptions.InternalServerErrorException;
import com.github.blog.usecase.exceptions.NotFoundErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostUseCaseImpl implements DeletePostUseCase {

    private final PostGateway postGateway;

    @Override
    public void execute(String uuid) {
        try {
            if(uuid == null || uuid.isBlank()) {
                throw new BadRequestErrorException();
            }

            boolean isDeleted = this.postGateway.delete(uuid);

            if (!isDeleted) {
                throw new NotFoundErrorException();
            }
        } catch (BadRequestErrorException ex) {
            throw new BadRequestErrorException("UUID do Post não foi informado.");
        } catch (NotFoundErrorException ex) {
            throw new NotFoundErrorException("UUID do Post é inválido.");
        } catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
