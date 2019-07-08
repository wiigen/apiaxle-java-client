package com.github.wiigen.client;

import com.github.wiigen.client.domain.ApiRequest;
import com.github.wiigen.client.domain.KeyRequest;
import com.github.wiigen.client.response.*;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class ApiAxleClient {

    private final WebTarget target;

    public ApiAxleClient(String host, int port, String version) {
        URI targetUri = UriBuilder.fromUri(host)
                .port(port)
                .build();

        target = ClientBuilder.newClient()
                .register(JacksonFeature.class)
                .target(targetUri)
                .path(version);
    }

    /*{
        "meta": {
        "version": 1,
                "status_code": 200
    },
        "results": {
        "protocol": "http",
                "tokenSkewProtectionCount": 3,
                "apiFormat": "json",
                "endPointTimeout": 2,
                "disabled": false,
                "strictSSL": true,
                "sendThroughApiKey": false,
                "sendThroughApiSig": false,
                "hasCapturePaths": false,
                "allowKeylessUse": false,
                "keylessQps": 2,
                "keylessQpm": 120,
                "keylessQpd": 172800,
                "qps": 2,
                "qpm": -1,
                "qpd": 172800,
                "corsEnabled": false,
                "endPoint": "lolz.google.com",
                "createdAt": 1562356881655
    }
    }*/

    /**
     * Provision a new API.
     *
     * @param name Name of the new API
     * @param apiDetails details for the new API
     * @return The API structure (including the timestamp fields).
     */
    public ApiResult createApi(String name, ApiRequest apiDetails) {
        Response response = target.path("api")
                .path(name)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(apiDetails));
        if (isOk(response)) {
            return response.readEntity(CreateApiResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    /*{
        "meta": {
        "version": 1,
                "status_code": 200
    },
        "results": {
        "protocol": "http",
                "tokenSkewProtectionCount": 3,
                "apiFormat": "json",
                "endPointTimeout": 2,
                "disabled": false,
                "strictSSL": true,
                "sendThroughApiKey": false,
                "sendThroughApiSig": false,
                "hasCapturePaths": false,
                "allowKeylessUse": false,
                "keylessQps": 2,
                "keylessQpm": 120,
                "keylessQpd": 172800,
                "qps": 2,
                "qpm": -1,
                "qpd": 172800,
                "corsEnabled": false,
                "endPoint": "lolz.google.com",
                "createdAt": 1562356881655
    }
    }*/
	/**
     * Get the definition of an API
     *
     * @param apiName Name of the API to return
     * @return The API structure (including the timestamp fields).
     */
    public ApiResult getApi(String apiName) {
        Response response = target.path("api")
                .path(apiName)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (isOk(response)) {
            return response.readEntity(CreateApiResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    public UpdateApiResult updateApi(String apiName, ApiRequest apiDetails) {
        Response response = target.path("api")
                .path(apiName)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(apiDetails));
        if (isOk(response)) {
            return response.readEntity(UpdateApiResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    public boolean deleteApi(String apiName) {
        Response response = target.path("api")
                .path(apiName)
                .request(MediaType.APPLICATION_JSON)
                .delete();
        if (isOk(response)) {
            return response.readEntity(DeleteApiResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    /*
     * {
     *   "meta": {
     *     "version": 1,
     *     "status_code": 200
     *   },
     *   "results": {}
     * }
     */

    //TODO: return json as an object
    public String getKeyCharts(String apiName) {
        return target.path("api")
                .path(apiName)
                .path("keycharts")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public KeyResult associateApiWithKey(String apiName, String key) {
        Response response = target.path("api")
                .path(apiName)
                .path("linkkey")
                .path(key)
                .property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true) // PUT empty data
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(null));
        if (isOk(response)) {
            return response.readEntity(CreateKeyResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    /*
     * {
     *   "meta": {
     *     "version": 1,
     *     "status_code": 200
     *   },
     *   "results": {
     *     "uncached": {},
     *     "cached": {},
     *     "error": {}
     *   }
     * }
     */

    public String getStatsForApi(String apiName) {
        return target.path("api")
                .path(apiName)
                .path("stats")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public String disassociateKeyWithApi(String apiName, String key) {
        Response response = target.path("api")
                .path(apiName)
                .path("unlinkkey")
                .path(key)
                .property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true) // PUT empty data
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(null));
        if (isOk(response)) {
            return response.readEntity(String.class);
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    /**
     * Lists all APIs
     *
     * @param from Index of the first api you want to see. Starts at zero. May be null (default: 0).
     * @param to Index of the last api you want to see. Starts at zero. May be null (default: 10).
     * @param resolve (default: false) If set to <code>true</code> then the details concerning the 
     * listed apis will also be printed. Be aware that this will come with a minor performace hit.
     * @return List of APIs
     */
    public GetApisResponse getApis(Integer from, Integer to, Boolean resolve) {
        Response response = target.path("apis")
                .queryParam("from", from)
                .queryParam("to", to)
                .queryParam("resolve", resolve)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (isOk(response)) {
            return response.readEntity(GetApisResponse.class);
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    /*
     * {
     *   "meta": {
     *     "version": 1,
     *     "status_code": 200
     *   },
     *   "results": {}
     * }
     */

    //TODO: return json as an object
    public String getApiCharts() {
        return target.path("apis")
                .path("charts")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public String getInfo() {
        return target.path("info")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    // ** KEYS **

    public List<String> getKeys(String apiName, Integer from, Integer to, Boolean resolve) {
        Response response = target.path("api")
                .path(apiName)
                .path("keys")
                .queryParam("from", from)
                .queryParam("to", to)
                .queryParam("resolve", resolve)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (isOk(response)) {
            return response.readEntity(GetKeysResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    /*{
       "meta": {
         "version": 1,
         "status_code": 200
       },
       "results": {
         "disabled": false,
         "sharedSecret": "lompa",
         "qpd": 5,
         "qpm": 50,
         "qps": 100,
         "apiLimits": "{\"lolz\":{\"qpd\":5000,\"qpm\":500,\"qps\":5}}",
         "allApis": false,
         "createdAt": 1551599386606
       }
     }*/

    /**
     * Create key.
     *
     * @param keyName name of the key.
     * @param keyRequest data associated with the key.
     * @return the result of the key.
     */
    public KeyResult createKey(String keyName, KeyRequest keyRequest) {
        Response response = target.path("key")
                .path(keyName)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(keyRequest));
        if (isOk(response)) {
            return response.readEntity(CreateKeyResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    public KeyResult createKeyGodMode(String keyName, KeyRequest keyRequest) {
        Response response = target.path("key")
                .path(keyName)
                .queryParam("isNSA", true)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(keyRequest));
        if (isOk(response)) {
            return response.readEntity(CreateKeyResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    /*{
       "meta": {
          "version": 1,
          "status_code": 200
        },
        "results": {
          "disabled": false,
          "sharedSecret": "lompa",
          "qpd": 5,
          "qpm": 50,
          "qps": 100,
          "apiLimits": "{\"lolz\":{\"qpd\":5000,\"qpm\":500,\"qps\":5}}",
          "allApis": false,
          "createdAt": 1551599386606,
          "apis": [
            "lolz"
          ]
        }
     }*/

    /**
     * Get key.
     *
     * @param keyName name of the key to retrieve.
     * @return the Key.
     */
    public KeyResult getKey(String keyName) {
        Response response = target.path("key")
                .path(keyName)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (isOk(response)) {
            return response.readEntity(GetKeyResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    public UpdateKeyResult updateKey(String keyName, KeyRequest keyRequest) {
        Response response = target.path("key")
                .path(keyName)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(keyRequest));
        if (isOk(response)) {
            return response.readEntity(UpdateKeyResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    public boolean deleteKey(String keyName) {
        Response response = target.path("key")
                .path(keyName)
                .request(MediaType.APPLICATION_JSON)
                .delete();
        if (isOk(response)) {
            return response.readEntity(DeleteApiResponse.class).getResults();
        } else {
            ErrorResponseResults errorResponse = response.readEntity(ErrorResponse.class).getResults();
            throw new ApiAxleClientException(errorResponse.getError().getMessage());
        }
    }

    /**
     * Ping the API for a super fast response.
     *
     * @return Just a <code>pong</code>.
     */
    public String ping() {
        return target.path("ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    private static boolean isOk(Response response) {
        return response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL;
    }

}
