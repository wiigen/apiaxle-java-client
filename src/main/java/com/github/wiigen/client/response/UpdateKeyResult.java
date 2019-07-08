package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateKeyResult {
    private final KeyResult oldKey;
    private final KeyResult newKey;

    UpdateKeyResult(@JsonProperty("old") KeyResult oldKey, @JsonProperty("new") KeyResult newKey) {
        this.oldKey = oldKey;
        this.newKey = newKey;
    }

    public KeyResult getOldKey() {
        return oldKey;
    }

    public KeyResult getNewKey() {
        return newKey;
    }
}
