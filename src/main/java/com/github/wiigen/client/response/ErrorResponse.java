package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
    private final Meta meta;
    private final ErrorResponseResults results;

    ErrorResponse(@JsonProperty("meta") Meta meta, @JsonProperty("results") ErrorResponseResults results) {
        this.meta = meta;
        this.results = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public ErrorResponseResults getResults() {
        return results;
    }
}
