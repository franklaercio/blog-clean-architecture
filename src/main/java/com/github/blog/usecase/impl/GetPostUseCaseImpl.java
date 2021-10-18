package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.gateways.PostGateway;
import com.github.blog.usecase.GetPostUseCase;
import com.github.blog.usecase.convert.response.PostUseCaseConvertResponse;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import com.github.blog.usecase.exceptions.BadRequestErrorException;
import com.github.blog.usecase.exceptions.InternalServerErrorException;
import com.github.blog.usecase.exceptions.NotFoundErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPostUseCaseImpl implements GetPostUseCase {

    private final PostGateway postGateway;

    private final PostUseCaseConvertResponse postUseCaseConvertResponse;

    @Override
    public PostControllerResponse execute(String title) {
        try{
            if(title == null || title.isBlank()) {
                throw new BadRequestErrorException("Título do Post não foi informado.");
            }

            PostUseCaseResponse postUseCaseResponse = this.postGateway.find(title);

            if (postUseCaseResponse == null) {
                throw new NotFoundErrorException("Não foi possível encontrar o post.");
            }

            return this.postUseCaseConvertResponse.convert(postUseCaseResponse);
        } catch (BadRequestErrorException ex) {
            throw new BadRequestErrorException("Título do Post não foi informado.");
        } catch (NotFoundErrorException ex) {
            throw new NotFoundErrorException("Não foi possível encontrar o post.");
        }catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
