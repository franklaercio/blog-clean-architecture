package com.github.blog.usecases.exceptions;

public class NotFoundErrorException extends RuntimeException {

    public NotFoundErrorException() {}

    public NotFoundErrorException(String message) {
        super(message);
    }
}
