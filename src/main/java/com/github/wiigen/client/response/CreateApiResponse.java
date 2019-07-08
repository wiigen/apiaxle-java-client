package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateApiResponse {
    private final Meta meta;
    private final ApiResult results;

    CreateApiResponse(@JsonProperty("meta") Meta meta, @JsonProperty("results") ApiResult results) {
        this.meta = meta;
        this.results = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public ApiResult getResults() {
        return results;
    }
}
