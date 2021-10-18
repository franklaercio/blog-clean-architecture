package com.github.blog.gateways;

import com.github.blog.usecase.data.request.UserUseCaseRequest;
import com.github.blog.usecase.data.response.UserUseCaseResponse;

public interface UserGateway {

    UserUseCaseResponse saveOrUpdate(UserUseCaseRequest userControllerRequest);

    UserUseCaseResponse findUser(String email);

    boolean deleteUser(String email);
}
