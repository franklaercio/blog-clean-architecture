package com.github.blog.usecases.exceptions;

public class BadRequestErrorException extends RuntimeException {

    public BadRequestErrorException() {}

    public BadRequestErrorException(String message) {
        super(message);
    }
}
