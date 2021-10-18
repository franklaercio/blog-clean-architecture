package com.github.blog.gateways;

import com.github.blog.usecase.data.request.PostUseCaseRequest;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import java.util.List;

public interface PostGateway {

    PostUseCaseResponse saveOrUpdate(PostUseCaseRequest postUseCaseRequest);

    PostUseCaseResponse find(String uuid);

    List<PostUseCaseResponse> findAll();

    boolean delete(String uuid);
}
