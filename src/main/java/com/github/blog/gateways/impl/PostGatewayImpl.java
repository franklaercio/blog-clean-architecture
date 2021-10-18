package com.github.blog.gateways.impl;

import com.github.blog.entities.PostEntity;
import com.github.blog.gateways.PostGateway;
import com.github.blog.gateways.convert.request.PostGatewayConvertRequest;
import com.github.blog.gateways.convert.response.FindAllPostGatewayConvertResponse;
import com.github.blog.gateways.convert.response.PostGatewayConvertResponse;
import com.github.blog.gateways.jpa.PostRepository;
import com.github.blog.usecase.data.request.PostUseCaseRequest;
import com.github.blog.usecase.data.response.PostUseCaseResponse;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostGatewayImpl implements PostGateway {

    private final PostRepository postRepository;

    private final PostGatewayConvertRequest postGatewayConvertRequest;

    private final PostGatewayConvertResponse postGatewayConvertResponse;

    private final FindAllPostGatewayConvertResponse findAllPostGatewayConvertResponse;

    @Override
    public PostUseCaseResponse saveOrUpdate(PostUseCaseRequest postUseCaseRequest) {
        PostEntity postEntity = this.postGatewayConvertRequest.convert(postUseCaseRequest);
        PostEntity response = this.postRepository.save(Objects.requireNonNull(postEntity));

        return this.postGatewayConvertResponse.convert(response);
    }

    @Override
    public PostUseCaseResponse find(String uuid) {
        List<PostEntity> response = this.postRepository.findByUuid(Objects.requireNonNull(UUID.fromString(uuid)));
        return this.postGatewayConvertResponse.convert(response.iterator().next());
    }

    @Override
    public List<PostUseCaseResponse> findAll() {
        return this.findAllPostGatewayConvertResponse.convert(this.postRepository.findAll());
    }

    @Override
    public boolean delete(String uuid) {
        List<PostEntity> postEntities = this.postRepository.findByUuid(
            Objects.requireNonNull(UUID.fromString(uuid)));

        if (!postEntities.isEmpty()) {
            this.postRepository.delete(postEntities.stream().iterator().next());
        } else {
            return false;
        }

        return true;
    }
}
