package com.github.blog.controllers;

import com.github.blog.controllers.data.request.PostControllerRequest;
import com.github.blog.controllers.data.response.PostControllerResponse;

import com.github.blog.usecase.DeletePostUseCase;
import com.github.blog.usecase.FindPostsUseCase;
import com.github.blog.usecase.GetPostUseCase;
import com.github.blog.usecase.SavePostUseCase;
import com.github.blog.usecase.UpdatePostUseCase;
import java.util.List;
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
@RequestMapping("/v1/post")
public class PostV1Controller {

    private final SavePostUseCase savePostUseCase;

    private final UpdatePostUseCase updatePostUseCase;

    private final DeletePostUseCase deletePostUseCase;

    private final GetPostUseCase getPostUseCase;

    private final FindPostsUseCase findPostsUseCase;

    @PostMapping
    public ResponseEntity<PostControllerResponse> create(@RequestBody PostControllerRequest postControllerRequest) {
        return ResponseEntity.ok(this.savePostUseCase.execute(postControllerRequest));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PostControllerResponse> getPost(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(this.getPostUseCase.execute(uuid));
    }

    @GetMapping
    public ResponseEntity<List<PostControllerResponse>> findAll() {
        return ResponseEntity.ok(this.findPostsUseCase.execute());
    }

    @PutMapping
    public ResponseEntity<PostControllerResponse> update(@RequestBody PostControllerRequest postControllerRequest) {
        return ResponseEntity.ok(this.updatePostUseCase.execute(postControllerRequest));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> delete(@PathVariable("uuid") String uuid) {
        this.deletePostUseCase.execute(uuid);
        return new ResponseEntity<>("Post apagado com sucesso.", HttpStatus.OK);
    }
}
