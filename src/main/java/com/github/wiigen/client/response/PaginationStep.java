package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginationStep {
    private final String href;
    private final int from;
    private final int to;

    PaginationStep(@JsonProperty("href") String href, @JsonProperty("from") int from, @JsonProperty("to") int to) {
        this.href = href;
        this.from = from;
        this.to = to;
    }

    public String getHref() {
        return href;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
