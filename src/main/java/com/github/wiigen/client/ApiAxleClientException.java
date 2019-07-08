package com.github.wiigen.client;

public class ApiAxleClientException extends RuntimeException {

    public ApiAxleClientException(String msg) {
        super(msg);
    }

    public ApiAxleClientException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
