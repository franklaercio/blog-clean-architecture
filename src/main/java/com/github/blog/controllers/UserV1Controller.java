package com.github.blog.controllers;

import com.github.blog.controllers.data.request.UserControllerRequest;
import com.github.blog.controllers.data.response.UserControllerResponse;
import com.github.blog.usecase.DeleteUserUseCase;
import com.github.blog.usecase.FindUsersUseCase;
import com.github.blog.usecase.SaveUserUseCase;
import com.github.blog.usecase.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserV1Controller {

    public final FindUsersUseCase findUsersUseCase;

    public final SaveUserUseCase saveUserUseCase;

    public final UpdateUserUseCase updateUserUseCase;

    public final DeleteUserUseCase deleteUserUseCase;

    @GetMapping
    public ResponseEntity<UserControllerResponse> find(@RequestHeader String email) {
        return this.findUsersUseCase.execute(email);
    }

    @PostMapping
    public ResponseEntity<UserControllerResponse> create(
            @RequestBody UserControllerRequest userControllerRequest) {
        return this.saveUserUseCase.execute(userControllerRequest);
    }

    @PutMapping
    public ResponseEntity<UserControllerResponse> update(@RequestBody UserControllerRequest userControllerRequest) {
        return this.updateUserUseCase.execute(userControllerRequest);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestHeader String email) {
        this.deleteUserUseCase.execute(email);
        return new ResponseEntity<>("Usuário apagado com sucesso.", HttpStatus.OK);
    }
}
