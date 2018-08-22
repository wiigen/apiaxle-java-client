package com.github.wiigen.client;

import java.net.URI;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.github.wiigen.client.domain.ApiDetails;

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

    /**
     * Provision a new API
     *
     * @param name Name of the new API
     * @param apiDetails details for the new API
     * @return
     */
    public ApiDetails createApi(String name, ApiDetails apiDetails) {
        return target.path("api")
                .path(name)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(apiDetails), ApiDetails.class);
    }

    /**
     * Get the definition of an API
     *
     * @param apiName
     * @return The API structure (including the timestamp fields).
     */
    public ApiDetails getApi(String apiName) {
        return target.path("api")
                .path(apiName)
                .request(MediaType.APPLICATION_JSON)
                .get(ApiDetails.class);
    }

    public void updateApi(String apiName, ApiDetails apiDetails) {
        target.path("api")
                .path(apiName)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(apiDetails));
    }

    public boolean deleteApi(String apiName) {
        return target.path("api")
                .path(apiName)
                .request(MediaType.APPLICATION_JSON)
                .delete(Boolean.class);
    }

    public String getKeyCharts(String apiName) {
        return target.path("api")
                .path(apiName)
                .path("keycharts")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public String getKeys(String apiName) {
        return target.path("api")
                .path(apiName)
                .path("keys")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public String associateApiWithKey(String apiName, String key) {
        return target.path("api")
                .path(apiName)
                .path("linkkey")
                .path(key)
                .request(MediaType.APPLICATION_JSON)
                .put(null, String.class);
    }

    public String getStatsForApi(String apiName) {
        return target.path("api")
                .path(apiName)
                .path("stats")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public void disassociateKeyWithApi(String apiName, String key) {
        target.path("api")
                .path(apiName)
                .path("unlinkkey")
                .path("key")
                .request(MediaType.APPLICATION_JSON)
                .put(null);
    }

    public String getApis() {
        return target.path("apis")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

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

    public void createKey(String keyName) {
        target.path("key")
                .path(keyName)
                .request(MediaType.APPLICATION_JSON)
                .post(null);
    }

    public String getKey(String keyName) {
        return target.path("key")
                .path(keyName)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public void updateKey(String keyName) {
        target.path("key")
                .path(keyName)
                .request(MediaType.APPLICATION_JSON)
                .post(null);
    }

    public boolean deleteKey(String keyName) {
        return target.path("key")
                .path(keyName)
                .request(MediaType.APPLICATION_JSON)
                .delete(Boolean.class);
    }

    /**
     * Ping the API for a super fast response.
     *
     * @return Just a 'pong'
     */
    public String ping() {
        return target.path("ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }
}
