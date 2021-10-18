package com.github.blog.gateways.jpa;

import com.github.blog.entities.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
}
