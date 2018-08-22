package com.github.wiigen.client.domain;

import java.util.Date;

public class ApiDetails {

    private Date createdAt; // (optional)
    private Date updatedAt; // (optional)

    /**
     * The endpoint for the API. For example; `graph.facebook.com`
     */
    private String endPoint;

    /**
     * (default: http) The protocol for the API, whether or not to use SSL
     */
    private String protocol = "http";
    private int tokenSkewProtectionCount = 3; // (default: 3) The amount of seconds you allow a valid token to be calculated against, either side of the current second. The higher the number the greater the computational cost.
    private String apiFormat = "json"; // (default: json) The resulting data type of the endpoint. This is redundant at the moment but will eventually support both XML too.
    private int endPointTimeout = 2; // (default: 2) Seconds to wait before timing out the connection

    private String extractKeyRegex; // (optional) Regular expression used to extract API key from url. Axle will use the **first** matched grouping and then apply that as the key. Using the `api_key` or `apiaxle_key` will take precedence.
    private String defaultPath; // (optional) An optional path part that will always be called when the API is hit.
    private boolean disabled; // (default: false) Disable this API causing errors when it's hit.
    private boolean strictSSL = true; // (default: true) Set to true to require that SSL certificates be valid.
    private boolean sendThroughApiKey; // (default: false) If true then the api_key parameter will be passed through in the request.
    private boolean sendThroughApiSig; // (default: false) If true then the api_sig parameter will be passed through in the request.
    private boolean hasCapturePaths; // (default: false) When true ApiAxle will parse and capture bits of information about the API being called.
    private boolean allowKeylessUse; //    (default: false) (optional) If true then allow for keyless access to this API. Also see keylessQps, keylessQpm, and keylessQpd.
    private int keylessQps = 2; // (default: 2) How many queries per second an anonymous key should have.
    private int keylessQpm = 120; // (default: 120) How many queries per minute an anonymous key should have.
    private int keylessQpd = 172800; // (default: 172800) How many queries per day an anonymous key should have.
    private int qps = 2; // (default: 2) Number of queries that can be called per second. Set to `-1` for no limit.
    private int qpm = -1; // (default: -1) Number of queries that can be called per minute. Set to `-1` for no limit.
    private int qpd = 172800; // (default: 172800) Number of queries that can be called per day. Set to `-1` for no limit.
    private boolean corsEnabled; // (default: false) (optional) Whether or not you want to enable CORS (http://www.w3.org/TR/cors/) support. This enables CORS for all origins and is intended to be simple and cover the majority of users. If you need more refined configuration we suggest you use something like varnish or nginx to do this. Note that your API endpoint should support the OPTIONS method which is often used in 'preflight' requests for the XHR object to verify CORS headers. When enabled, the following headers will be returned: Access-Control-Allow-Origin: * Access-Control-Allow-Credentials: true Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS, PATCH, HEAD Access-Control-Allow-Headers: Origin, Accept, Content-Type, X-Requested-With, X-CSRF-Token Access-Control-Expose-Headers: content-type, content-length, X-ApiaxleProxy-Qps-Left, X-ApiaxleProxy-Qpm-Left, X-ApiaxleProxy-Qpd-Left
    private String errorMessage; // (optional) This gets added as an info property to any errors returned by the proxy for this api.
    // additionalHeaders    (optional) URL encoded list of headers and values to be transformed into headers on the endpoint call, e.g., X-SPECIAL=1234&X-VENDOR-TYPE=abc&UNIQUE-VALUE=2js3j%3Dasd

}
