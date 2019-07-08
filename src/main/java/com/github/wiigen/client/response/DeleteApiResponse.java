package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteApiResponse {
    private final Meta meta;
    private final boolean results;

    DeleteApiResponse(@JsonProperty("meta") Meta meta, @JsonProperty("results") boolean results) {
        this.meta = meta;
        this.results = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public boolean getResults() {
        return results;
    }

}
