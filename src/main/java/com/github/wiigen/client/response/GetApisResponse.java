package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetApisResponse {
    private final MetaWithPagination meta;
    private final List<String> results;

    GetApisResponse(@JsonProperty("meta") MetaWithPagination meta, @JsonProperty("results") List<String> results) {
        this.meta = meta;
        this.results = results;
    }

    public MetaWithPagination getMeta() {
        return meta;
    }

    public List<String> getResults() {
        return results;
    }
}
