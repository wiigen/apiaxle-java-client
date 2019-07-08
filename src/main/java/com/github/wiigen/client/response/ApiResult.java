package com.github.wiigen.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ApiResult {
    private final Date createdAt; //
    private final Date updatedAt;
    private final String endPoint; //
    private final String protocol; //
    private final int tokenSkewProtectionCount; //
    private final String apiFormat; //
    private final int endPointTimeout; //
    private final String extractKeyRegex;
    private final String defaultPath;
    private final boolean disabled; //
    private final boolean strictSSL; //
    private final boolean sendThroughApiKey; //
    private final boolean sendThroughApiSig; //
    private final boolean hasCapturePaths; //
    private final boolean allowKeylessUse; //
    private final int keylessQps; //
    private final int keylessQpm; //
    private final int keylessQpd; //
    private final int qps; //
    private final int qpm; //
    private final int qpd; //
    private final boolean corsEnabled; //
    private final String errorMessage; //
    private final String additionalHeaders; //

    ApiResult(
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("updatedAt") Date updatedAt,
            @JsonProperty("endPoint") String endPoint,
            @JsonProperty("protocol") String protocol,
            @JsonProperty("tokenSkewProtectionCount") int tokenSkewProtectionCount,
            @JsonProperty("apiFormat") String apiFormat,
            @JsonProperty("endpointTimeout") int endPointTimeout,
            @JsonProperty("extractKeyRegex") String extractKeyRegex,
            @JsonProperty("defaultPath") String defaultPath,
            @JsonProperty("disabled") boolean disabled,
            @JsonProperty("strictSSL") boolean strictSSL,
            @JsonProperty("sendThroughApiKey") boolean sendThroughApiKey,

            @JsonProperty("sendThroughApiSig") boolean sendThroughApiSig,
            @JsonProperty("hasCapturePaths") boolean hasCapturePaths,
            @JsonProperty("allowKeylessUse") boolean allowKeylessUse,
            @JsonProperty("keylessQps") int keylessQps,
            @JsonProperty("keylessQpm") int keylessQpm,
            @JsonProperty("keylessQpd") int keylessQpd,
            @JsonProperty("qps") int qps,
            @JsonProperty("qpm") int qpm,
            @JsonProperty("qpd") int qpd,
            @JsonProperty("corsEnabled") boolean corsEnabled,
            @JsonProperty("errorMessage") String errorMessage,
            @JsonProperty("additionalHeaders") String additionalHeaders
    ) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.endPoint = endPoint;
        this.protocol = protocol;
        this.tokenSkewProtectionCount = tokenSkewProtectionCount;
        this.apiFormat = apiFormat;
        this.endPointTimeout = endPointTimeout;
        this.extractKeyRegex = extractKeyRegex;
        this.defaultPath = defaultPath;
        this.disabled = disabled;
        this.strictSSL = strictSSL;
        this.sendThroughApiKey = sendThroughApiKey;
        this.sendThroughApiSig = sendThroughApiSig;
        this.hasCapturePaths = hasCapturePaths;
        this.allowKeylessUse = allowKeylessUse;
        this.keylessQps = keylessQps;
        this.keylessQpm = keylessQpm;
        this.keylessQpd = keylessQpd;
        this.qps = qps;
        this.qpm = qpm;
        this.qpd = qpd;
        this.corsEnabled = corsEnabled;
        this.errorMessage = errorMessage;
        this.additionalHeaders = additionalHeaders;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getTokenSkewProtectionCount() {
        return tokenSkewProtectionCount;
    }

    public String getApiFormat() {
        return apiFormat;
    }

    public Integer getEndPointTimeout() {
        return endPointTimeout;
    }

    public String getExtractKeyRegex() {
        return extractKeyRegex;
    }

    public String getDefaultPath() {
        return defaultPath;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public boolean getStrictSSL() {
        return strictSSL;
    }

    public boolean getSendThroughApiKey() {
        return sendThroughApiKey;
    }

    public boolean getSendThroughApiSig() {
        return sendThroughApiSig;
    }

    public boolean getHasCapturePaths() {
        return hasCapturePaths;
    }

    public boolean getAllowKeylessUse() {
        return allowKeylessUse;
    }

    public int getKeylessQps() {
        return keylessQps;
    }

    public int getKeylessQpm() {
        return keylessQpm;
    }

    public int getKeylessQpd() {
        return keylessQpd;
    }

    public int getQps() {
        return qps;
    }

    public int getQpm() {
        return qpm;
    }

    public int getQpd() {
        return qpd;
    }

    public boolean getCorsEnabled() {
        return corsEnabled;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getAdditionalHeaders() {
        return additionalHeaders;
    }

}
