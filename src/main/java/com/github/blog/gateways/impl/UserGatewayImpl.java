package com.github.blog.gateways.impl;

import com.github.blog.entities.UserEntity;
import com.github.blog.gateways.UserGateway;
import com.github.blog.gateways.convert.request.UserGatewayConvertRequest;
import com.github.blog.gateways.convert.response.UserGatewayConvertResponse;
import com.github.blog.gateways.jpa.UserRepository;
import com.github.blog.usecases.data.request.UserUseCaseRequest;
import com.github.blog.usecases.data.response.UserUseCaseResponse;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    private final UserGatewayConvertRequest userGatewayConvertRequest;

    private final UserGatewayConvertResponse userGatewayConvertResponse;

    @Override
    public UserUseCaseResponse saveOrUpdate(UserUseCaseRequest userUseCaseRequest) {
        UserEntity userEntity = this.userGatewayConvertRequest.convert(userUseCaseRequest);

        UserEntity userSave = this.userRepository.save(Objects.requireNonNull(userEntity));

        return this.userGatewayConvertResponse.convert(userSave);
    }

    @Override
    public UserUseCaseResponse findUser(String email) {
        List<UserEntity> userEntity = this.userRepository.findByPersonEmail(Objects.requireNonNull(email));

        if (userEntity.isEmpty()) {
            return null;
        }

        return this.userGatewayConvertResponse.convert(userEntity.iterator().next());
    }

    @Override
    public boolean deleteUser(String email) {
        List<UserEntity> userEntity = this.userRepository.findByPersonEmail(Objects.requireNonNull(email));

        if(!userEntity.isEmpty()) {
            this.userRepository.delete(userEntity.stream().iterator().next());
        } else {
            return false;
        }

        return true;
    }
}
