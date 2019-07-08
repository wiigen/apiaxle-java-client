package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateKeyResponse {
    private final Meta meta;
    private final UpdateKeyResult results;

    UpdateKeyResponse(@JsonProperty("meta") Meta meta, @JsonProperty("results") UpdateKeyResult results) {
        this.meta = meta;
        this.results = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public UpdateKeyResult getResults() {
        return results;
    }
}
