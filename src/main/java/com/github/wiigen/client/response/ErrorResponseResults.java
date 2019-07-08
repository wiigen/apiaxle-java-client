package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseResults {
    private final ErrorResponseError error;

    ErrorResponseResults(@JsonProperty("error") ErrorResponseError error) {
        this.error = error;
    }

    public ErrorResponseError getError() {
        return error;
    }
}
