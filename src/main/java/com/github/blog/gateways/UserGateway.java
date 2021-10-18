package com.github.blog.gateways;

import com.github.blog.usecases.data.request.UserUseCaseRequest;
import com.github.blog.usecases.data.response.UserUseCaseResponse;

public interface UserGateway {

    UserUseCaseResponse saveOrUpdate(UserUseCaseRequest userControllerRequest);

    UserUseCaseResponse findUser(String email);

    boolean deleteUser(String email);
}
