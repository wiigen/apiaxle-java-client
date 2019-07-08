package com.github.wiigen.client.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;

@SuppressWarnings("WeakerAccess")
@JsonInclude(Include.NON_NULL)
public class ApiRequest {

    private Date createdAt;
    private Date updatedAt;
    private String endPoint;
    private String protocol;
    private Integer tokenSkewProtectionCount;
    private String apiFormat;
    private Integer endPointTimeout;
    private String extractKeyRegex;
    private String defaultPath;
    private Boolean disabled;
    private Boolean strictSSL;
    private Boolean sendThroughApiKey;
    private Boolean sendThroughApiSig;
    private Boolean hasCapturePaths;
    private Boolean allowKeylessUse;
    private int keylessQps;
    private int keylessQpm;
    private int keylessQpd;
    private int qps;
    private int qpm;
    private int qpd;
    private Boolean corsEnabled;
    private String errorMessage;
    private String additionalHeaders;

    private ApiRequest(Date createdAt, Date updatedAt, String endPoint, String protocol, Integer tokenSkewProtectionCount,
                       String apiFormat, Integer endPointTimeout, String extractKeyRegex, String defaultPath, Boolean disabled,
                       Boolean strictSSL, Boolean sendThroughApiKey, Boolean sendThroughApiSig, Boolean hasCapturePaths,
                       Boolean allowKeylessUse, int keylessQps, int keylessQpm, int keylessQpd, int qps, int qpm, int qpd,
                       Boolean corsEnabled, String errorMessage, String additionalHeaders) {
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

    @Override
    public String toString() {
        return "ApiRequest{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", endPoint='" + endPoint + '\'' +
                ", protocol='" + protocol + '\'' +
                ", tokenSkewProtectionCount=" + tokenSkewProtectionCount +
                ", apiFormat='" + apiFormat + '\'' +
                ", endPointTimeout=" + endPointTimeout +
                ", extractKeyRegex='" + extractKeyRegex + '\'' +
                ", defaultPath='" + defaultPath + '\'' +
                ", disabled=" + disabled +
                ", strictSSL=" + strictSSL +
                ", sendThroughApiKey=" + sendThroughApiKey +
                ", sendThroughApiSig=" + sendThroughApiSig +
                ", hasCapturePaths=" + hasCapturePaths +
                ", allowKeylessUse=" + allowKeylessUse +
                ", keylessQps=" + keylessQps +
                ", keylessQpm=" + keylessQpm +
                ", keylessQpd=" + keylessQpd +
                ", qps=" + qps +
                ", qpm=" + qpm +
                ", qpd=" + qpd +
                ", corsEnabled=" + corsEnabled +
                ", errorMessage='" + errorMessage + '\'' +
                ", additionalHeaders='" + additionalHeaders + '\'' +
                '}';
    }

    /**
     * The endpoint for the API. For example; <code>graph.facebook.com</code>
     * 
     * @param endPoint the endpoint for the API.
     * @return a new ApiRequestBuilder.
     */
    public static ApiRequestBuilder builder(String endPoint) {
        return new ApiRequestBuilder(endPoint);
    }

    public static class ApiRequestBuilder {
        private final String endPoint;
        private Date createdAt;
        private Date updatedAt;
        private String protocol;
        private Integer tokenSkewProtectionCount;
        private String apiFormat;
        private Integer endPointTimeout;
        private String extractKeyRegex;
        private String defaultPath;
        private Boolean disabled;
        private Boolean strictSSL;
        private Boolean sendThroughApiKey;
        private Boolean sendThroughApiSig;
        private Boolean hasCapturePaths;
        private Boolean allowKeylessUse;
        private int keylessQps = 2;
        private int keylessQpm = 120;
        private int keylessQpd = 172800;
        private int qps = 2;
        private int qpm = -1;
        private int qpd = 172800;
        private Boolean corsEnabled;
        private String errorMessage;
        private String additionalHeaders;

        ApiRequestBuilder(String endpoint) {
            endPoint = endpoint;
        }

        /**
         * Provide a date when the api was created.
         * 
         * @param createdAt date the api was created.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Provide a date when the api was updated.
         * 
         * @param updatedAt date the api was updated.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * The protocol for the API, whether or not to use SSL
         *
         * @param protocol the protocol (default: <code>http</code>).
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * The amount of seconds you allow a valid token to be calculated against, either side of the current second.
         * The higher the number the greater the computational cost.
         *
         * @param tokenSkewProtectionCount number of seconds (default: <code>3</code>).
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder tokenSkewProtectionCount(int tokenSkewProtectionCount) {
            this.tokenSkewProtectionCount = tokenSkewProtectionCount;
            return this;
        }

        /**
         * The resulting data type of the endpoint. This is redundant at the moment but will eventually
         * support both XML too.
         *
         * @param apiFormat format of the api (default: <code>json</code>).
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder apiFormat(String apiFormat) {
            this.apiFormat = apiFormat;
            return this;
        }

        /**
         * (default: 2) Seconds to wait before timing out the connection
         * @param endPointTimeout Number of seconds to wait
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder endPointTimeout(int endPointTimeout) {
            this.endPointTimeout = endPointTimeout;
            return this;
        }

        /**
         * An optional regular expression used to extract API key from url. Axle will use the
         * **first** matched grouping and then apply that as the key. Using the `api_key` or
         * `apiaxle_key` will take precedence.
         *
         * @param extractKeyRegex The regex expression.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder extractKeyRegex(String extractKeyRegex) {
            this.extractKeyRegex = extractKeyRegex;
            return this;
        }

        /**
         * An optional path part that will always be called when the API is hit.
         * @param defaultPath path value
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder defaultPath(String defaultPath) {
            this.defaultPath = defaultPath;
            return this;
        }

        /**
         * Disable this API causing errors when it's hit.
         *
         * @param disabled set true to disable errors. Default: <code>false</code>.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder disabled(boolean disabled) {
            this.disabled = disabled;
            return this;
        }

        /**
         * Set to true to require that SSL certificates be valid.
         *
         * @param strictSSL require strict SSL. Default: <code>true</code>.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder strictSSL(boolean strictSSL) {
            this.strictSSL = strictSSL;
            return this;
        }

        /**
         * If true then the api_key parameter will be passed through in the request.
         *
         * @param sendThroughApiKey Pass api_key as part of the request. Default: <code>false</code>.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder sendThroughApiKey(boolean sendThroughApiKey) {
            this.sendThroughApiKey = sendThroughApiKey;
            return this;
        }

        /**
         * If true then the api_sig parameter will be passed through in the request.
         *
         * @param sendThroughApiSig pass the api_sig parameter through the request. Default <code>false</code>.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder sendThroughApiSig(boolean sendThroughApiSig) {
            this.sendThroughApiSig = sendThroughApiSig;
            return this;
        }

        /**
         * When true ApiAxle will parse and capture bits of information about the API being called.
         *
         * @param hasCapturePaths capture data. Default: <code>false</code>.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder hasCapturePaths(boolean hasCapturePaths) {
            this.hasCapturePaths = hasCapturePaths;
            return this;
        }

        /**
         * If true then allow for keyless access to this API. Also see:
         * {@link ApiRequest#keylessQps}, {@link ApiRequest#keylessQpm}, and {@link ApiRequest#keylessQpd}.
         *
         * @param allowKeylessUse allow keyless access (default: <code>false</code>).
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder allowKeylessUse(boolean allowKeylessUse) {
            this.allowKeylessUse = allowKeylessUse;
            return this;
        }

        /**
         * How many queries per second an anonymous key should have.
         *
         * @param keylessQps number of queries per second an anonymous key should have (default: <code>2</code>).
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder keylessQps(int keylessQps) {
            this.keylessQps = keylessQps;
            return this;
        }

        /**
         * How many queries per minute an anonymous key should have.
         *
         * @param keylessQpm number of queries per minute an anonymous key should have (default: <code>120</code>).
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder keylessQpm(int keylessQpm) {
            this.keylessQpm = keylessQpm;
            return this;
        }

        /**
         * How many queries per day an anonymous key should have.
         *
         * @param keylessQpd number of queries per day an anonymous key should have (default: <code>172800</code>).
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder keylessQpd(int keylessQpd) {
            this.keylessQpd = keylessQpd;
            return this;
        }

        /**
         * Number of queries that can be called per day.
         *
         * @param qpd Number of queries that can be called per minute.
         *            Default: <code>172800</code>. Set to <code>-1</code> for no limit.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder qpd(int qpd) {
            this.qpd = qpd;
            return this;
        }

        /**
         * Number of queries that can be called per minute.
         *
         * @param qpm Number of queries that can be called per minute.
         *            Default: <code>-1</code>. Set to <code>-1</code> for no limit.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder qpm(int qpm) {
            this.qpm = qpm;
            return this;
        }

        /**
         * Number of queries that can be called per second.
         *
         * @param qps Number of queries that can be called per second.
         *            Default: <code>2</code>. Set to <code>-1</code> for no limit.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder qps(int qps) {
            this.qps = qps;
            return this;
        }

        /**
         * Whether or not you want to enable CORS (http://www.w3.org/TR/cors/) support.
         * This enables CORS for all origins and is intended to be simple and cover the majority of users. If you
         * need more refined configuration we suggest you use something like varnish or nginx to do this. Note that
         * your API endpoint should support the OPTIONS method which is often used in 'preflight' requests for the
         * XHR object to verify CORS headers. When enabled, the following headers will be returned:
         * Access-Control-Allow-Origin: * Access-Control-Allow-Credentials: true Access-Control-Allow-Methods: GET,
         * POST, PUT, DELETE, OPTIONS, PATCH, HEAD Access-Control-Allow-Headers: Origin, Accept, Content-Type, X-Requested-With,
         * X-CSRF-Token Access-Control-Expose-Headers: content-type, content-length, X-ApiaxleProxy-Qps-Left,
         * X-ApiaxleProxy-Qpm-Left, X-ApiaxleProxy-Qpd-Left
         *
         * @param corsEnabled to enable cors (default: <code>false</code>).
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder corsEnabled(boolean corsEnabled) {
            this.corsEnabled = corsEnabled;
            return this;
        }

        /**
         * This gets added as an info property to any errors returned by the proxy for this api.
         *
         * @param errorMessage info message.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        /**
         * Optional URL encoded list of headers and values to be transformed into headers on the endpoint call,
         * e.g. <code>X-SPECIAL=1234&X-VENDOR-TYPE=abc&UNIQUE-VALUE=2js3j%3Dasd</code>.
         *
         * @param additionalHeaders list of headers.
         * @return updated ApiRequestBuilder.
         */
        public ApiRequestBuilder additionalHeaders(String additionalHeaders) {
            this.additionalHeaders = additionalHeaders;
            return this;
        }

        public ApiRequest build() {
            return new ApiRequest(createdAt, updatedAt, endPoint, protocol, tokenSkewProtectionCount, apiFormat,
                    endPointTimeout, extractKeyRegex, defaultPath, disabled, strictSSL, sendThroughApiKey,
                    sendThroughApiSig, hasCapturePaths, allowKeylessUse, keylessQps, keylessQpm, keylessQpd, qps, qpm,
                    qpd, corsEnabled, errorMessage, additionalHeaders);
        }
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

    public Integer getTokenSkewProtectionCount() {
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

    public Boolean isDisabled() {
        return disabled;
    }

    public Boolean isStrictSSL() {
        return strictSSL;
    }

    public Boolean isSendThroughApiKey() {
        return sendThroughApiKey;
    }

    public Boolean isSendThroughApiSig() {
        return sendThroughApiSig;
    }

    public Boolean isHasCapturePaths() {
        return hasCapturePaths;
    }

    public Boolean isAllowKeylessUse() {
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

    public Boolean isCorsEnabled() {
        return corsEnabled;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getAdditionalHeaders() {
        return additionalHeaders;
    }

}
