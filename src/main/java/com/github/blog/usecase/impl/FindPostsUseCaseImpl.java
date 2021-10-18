package com.github.blog.usecase.impl;

import com.github.blog.controllers.data.response.PostControllerResponse;
import com.github.blog.gateways.PostGateway;
import com.github.blog.usecase.FindPostsUseCase;
import com.github.blog.usecase.convert.response.FindPostsUseCaseConvertResponse;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
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
        List<PostUseCaseResponse> postUseCaseResponses = this.postGateway.findAll();
        return this.findPostsUseCaseConvertResponse.convert(postUseCaseResponses);
    }
}
