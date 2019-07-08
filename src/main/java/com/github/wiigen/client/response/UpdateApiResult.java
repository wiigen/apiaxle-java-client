package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateApiResult {
    private final ApiResult oldApi;
    private final ApiResult newApi;

    UpdateApiResult(@JsonProperty("old") ApiResult oldApi, @JsonProperty("new") ApiResult newApi) {
        this.oldApi = oldApi;
        this.newApi = newApi;
    }

    public ApiResult getOldApi() {
        return oldApi;
    }

    public ApiResult getNewApi() {
        return newApi;
    }
}
