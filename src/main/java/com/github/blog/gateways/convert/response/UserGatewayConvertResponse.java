package com.github.blog.gateways.convert.response;

import com.github.blog.entities.UserEntity;
import com.github.blog.usecase.data.request.UserUseCaseRequest;
import com.github.blog.usecase.data.response.UserUseCaseResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserGatewayConvertResponse implements Converter<UserEntity, UserUseCaseResponse> {

    @Override
    public UserUseCaseResponse convert(UserEntity source) {
        return UserUseCaseResponse.builder()
            .name(source.getPerson().getName())
            .email(source.getPerson().getEmail())
            .build();
    }
}
