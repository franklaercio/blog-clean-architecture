package com.github.blog.usecases.convert.response;

import com.github.blog.controllers.data.response.UserControllerResponse;
import com.github.blog.usecases.data.response.UserUseCaseResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("UserUseCaseConvertResponse")
public class UserUseCaseConvertResponse implements
    Converter<UserUseCaseResponse, UserControllerResponse> {

    @Override
    public UserControllerResponse convert(UserUseCaseResponse source) {
        return UserControllerResponse.builder()
            .name(source.getName())
            .email(source.getEmail())
            .build();
    }
}
