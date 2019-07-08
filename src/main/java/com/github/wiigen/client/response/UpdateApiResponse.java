package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateApiResponse {
    private final Meta meta;
    private final UpdateApiResult results;

    UpdateApiResponse(@JsonProperty("meta") Meta meta, @JsonProperty("results") UpdateApiResult results) {
        this.meta = meta;
        this.results = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public UpdateApiResult getResults() {
        return results;
    }
}
