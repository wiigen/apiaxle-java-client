package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class KeyResult {
    private final Date createdAt;
    private final Date updatedAt;
    private final String sharedSecret;
    private final int qpd;
    private final int qpm;
    private final int qps;
    private final boolean disabled;
    private final String apiLimits;
    private final boolean allApis;

    private List<String> apis;

    KeyResult(
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("updatedAt") Date updatedAt,
            @JsonProperty("sharedSecret") String sharedSecret,
            @JsonProperty("qpd") int qpd,
            @JsonProperty("qpm") int qpm,
            @JsonProperty("qps") int qps,
            @JsonProperty("disabled") boolean disabled,
            @JsonProperty("apiLimits") String apiLimits,
            @JsonProperty("allApis") boolean allApis,
            @JsonProperty("apis") List<String> apis)
    {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sharedSecret = sharedSecret;
        this.qpd = qpd;
        this.qpm = qpm;
        this.qps = qps;
        this.disabled = disabled;
        this.apiLimits = apiLimits;
        this.allApis = allApis;
        this.apis = apis;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getSharedSecret() {
        return sharedSecret;
    }

    public int getQpd() {
        return qpd;
    }

    public int getQpm() {
        return qpm;
    }

    public int getQps() {
        return qps;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public String getApiLimits() {
        return apiLimits;
    }

    public boolean getAllApis() {
        return allApis;
    }

    public List<String> getApis() {
        return apis;
    }
}
