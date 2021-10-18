package com.github.blog.gateways.jpa;

import com.github.blog.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query("FROM UserEntity u INNER JOIN PersonEntity p ON p.id = u.person.id WHERE p.email = :email")
    List<UserEntity> findByPersonEmail(String email);
}
