package com.github.blog.gateways.convert.request;

import com.github.blog.entities.PersonEntity;
import com.github.blog.entities.UserEntity;
import com.github.blog.entities.enums.Status;
import com.github.blog.entities.enums.UserType;
import com.github.blog.usecases.data.request.UserUseCaseRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserGatewayConvertRequest implements Converter<UserUseCaseRequest, UserEntity> {

    @Override
    public UserEntity convert(UserUseCaseRequest source) {

        PersonEntity personEntity = PersonEntity.builder()
            .name(source.getName())
            .email(source.getEmail())
            .build();

        return UserEntity.builder()
            .username(source.getUsername())
            .password(source.getPassword())
            .status(Status.AVAILABLE)
            .userType(UserType.CUSTOMER)
            .person(personEntity)
            .build();
    }
}
