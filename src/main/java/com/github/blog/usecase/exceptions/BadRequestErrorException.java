package com.github.blog.usecase.exceptions;

public class BadRequestErrorException extends RuntimeException {

    public BadRequestErrorException() {}

    public BadRequestErrorException(String message) {
        super(message);
    }
}
