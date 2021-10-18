package com.github.blog.gateways.exceptions;

public class GatewayInternalServerErrorException extends RuntimeException {

    public GatewayInternalServerErrorException(String message) {
        super(message);
    }
}
