package com.github.blog.gateways.jpa;

import com.github.blog.entities.PostEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Integer> {

    @Query("FROM PostEntity p WHERE p.id = :id")
    List<PostEntity> findByUuid(UUID id);
}
