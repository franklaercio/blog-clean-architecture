package com.github.blog.controllers;

import com.github.blog.controllers.data.response.GeneralErrorResponse;
import com.github.blog.gateways.exceptions.GatewayInternalServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GatewayInternalServerErrorException.class)
    public ResponseEntity<GeneralErrorResponse> handleCityNotFoundException() {
        GeneralErrorResponse generalErrorResponse = GeneralErrorResponse.builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message("Ocorreu um problema interno.")
            .build();

        return new ResponseEntity<>(generalErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
