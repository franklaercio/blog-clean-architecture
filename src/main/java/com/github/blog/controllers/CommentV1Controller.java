package com.github.blog.controllers;

import com.github.blog.controllers.data.request.CommentControllerRequest;
import com.github.blog.controllers.data.response.CommentControllerResponse;
import com.github.blog.usecase.impl.FindCommentsUseCaseImpl;
import com.github.blog.usecase.impl.PublishCommentUseCaseImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/comment")
public class CommentV1Controller {

    public final PublishCommentUseCaseImpl commentUseCaseImpl;

    public final FindCommentsUseCaseImpl findAllCommentUseCase;

    @PostMapping
    public ResponseEntity<CommentControllerResponse> publishComment(
            CommentControllerRequest commentControllerRequest) {
        return new ResponseEntity<>(this.commentUseCaseImpl.execute(commentControllerRequest),
            HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CommentControllerResponse>> getAllComments() {
        return new ResponseEntity<>(this.findAllCommentUseCase.execute(),
            HttpStatus.OK);
    }
}
