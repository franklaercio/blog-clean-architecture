package com.github.blog.usecases.impl;

import com.github.blog.controllers.data.response.CommentControllerResponse;
import com.github.blog.gateways.CommentGateway;
import com.github.blog.usecases.FindCommentsUseCase;
import com.github.blog.usecases.convert.response.FindCommentsUseCaseConvertResponse;
import com.github.blog.usecases.data.response.CommentUseCaseResponse;
import com.github.blog.usecases.exceptions.InternalServerErrorException;
import com.github.blog.usecases.exceptions.NotFoundErrorException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCommentsUseCaseImpl implements FindCommentsUseCase {

    private final CommentGateway commentGateway;

    private final FindCommentsUseCaseConvertResponse commentUseCaseConvertResponse;

    @Override
    public List<CommentControllerResponse> execute() {
        try{
            List<CommentUseCaseResponse> commentUseCaseResponses = this.commentGateway.findAllComments();

            if (commentUseCaseResponses.isEmpty()) {
                throw new NotFoundErrorException();
            }

            return this.commentUseCaseConvertResponse.convert(commentUseCaseResponses);
        } catch (NotFoundErrorException ex) {
            throw new NotFoundErrorException("Não foi possível encontrar nenhum comentário.");
        } catch (RuntimeException ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
}
