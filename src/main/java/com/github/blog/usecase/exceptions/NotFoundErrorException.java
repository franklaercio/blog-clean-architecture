package com.github.blog.usecase.exceptions;

public class NotFoundErrorException extends RuntimeException {

    public NotFoundErrorException() {}

    public NotFoundErrorException(String message) {
        super(message);
    }
}
