package com.github.blog.controllers;

import com.github.blog.controllers.data.response.GeneralErrorResponse;
import com.github.blog.usecase.exceptions.BadRequestErrorException;
import com.github.blog.usecase.exceptions.InternalServerErrorException;
import com.github.blog.usecase.exceptions.NotFoundErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<GeneralErrorResponse> handleInternalServerErrorException() {
        GeneralErrorResponse generalErrorResponse = GeneralErrorResponse.builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .description(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
            .message("Ocorreu um problema interno.")
            .build();

        return new ResponseEntity<>(generalErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundErrorException.class)
    public ResponseEntity<GeneralErrorResponse> handleNotFoundErrorException(NotFoundErrorException notFoundErrorException) {
        GeneralErrorResponse generalErrorResponse = GeneralErrorResponse.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .description(HttpStatus.NOT_FOUND.getReasonPhrase())
            .message(notFoundErrorException.getMessage())
            .build();

        return new ResponseEntity<>(generalErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestErrorException.class)
    public ResponseEntity<GeneralErrorResponse> handleBadRequestErrorException(BadRequestErrorException badRequestErrorException) {
        GeneralErrorResponse generalErrorResponse = GeneralErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .description(HttpStatus.BAD_REQUEST.getReasonPhrase())
            .message(badRequestErrorException.getMessage())
            .build();

        return new ResponseEntity<>(generalErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
