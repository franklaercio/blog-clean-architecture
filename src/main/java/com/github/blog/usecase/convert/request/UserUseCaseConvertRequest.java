package com.github.blog.usecase.convert.request;

import com.github.blog.controllers.data.request.UserControllerRequest;
import com.github.blog.usecase.data.request.UserUseCaseRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("UserUseCaseConvertRequest")
public class UserUseCaseConvertRequest implements
    Converter<UserControllerRequest, UserUseCaseRequest> {

    @Override
    public UserUseCaseRequest convert(UserControllerRequest source) {
        return UserUseCaseRequest.builder()
            .name(source.getName())
            .email(source.getEmail())
            .username(source.getUsername())
            .password(source.getPassword())
            .build();
    }
}
