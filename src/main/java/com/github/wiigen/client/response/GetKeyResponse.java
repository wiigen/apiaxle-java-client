package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetKeyResponse {
    private final Meta meta;
    private final KeyResult results;

    GetKeyResponse(@JsonProperty("meta") Meta meta, @JsonProperty("results") KeyResult results) {
        this.meta = meta;
        this.results = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public KeyResult getResults() {
        return results;
    }
}
