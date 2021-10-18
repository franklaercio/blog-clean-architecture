package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.gateways.PostGateway;
import com.github.blog.usecase.FindPostsUseCase;
import com.github.blog.usecase.convert.response.FindPostsUseCaseConvertResponse;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import com.github.blog.usecase.exceptions.InternalServerErrorException;
import com.github.blog.usecase.exceptions.NotFoundErrorException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPostsUseCaseImpl implements FindPostsUseCase {

    private final PostGateway postGateway;

    private final FindPostsUseCaseConvertResponse findPostsUseCaseConvertResponse;

    @Override
    public List<PostControllerResponse> execute() {
        try{
            List<PostUseCaseResponse> postUseCaseResponses = this.postGateway.findAll();

            if (postUseCaseResponses.isEmpty()) {
                throw new NotFoundErrorException("Não foi possível encontrar nenhum post.");
            }

            return this.findPostsUseCaseConvertResponse.convert(postUseCaseResponses);
        } catch (NotFoundErrorException ex) {
            throw new NotFoundErrorException("Não foi possível encontrar nenhum usuário.");
        } catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
