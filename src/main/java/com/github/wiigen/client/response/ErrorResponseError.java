package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseError {
    private final String type;
    private final String message;

    ErrorResponseError(@JsonProperty("type") String type, @JsonProperty("message") String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
