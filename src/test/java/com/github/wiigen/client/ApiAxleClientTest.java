package com.github.wiigen.client;

import com.github.wiigen.client.domain.KeyRequest;
import com.github.wiigen.client.resource.MockApiResource;
import com.github.wiigen.client.response.ApiResult;
import com.github.wiigen.client.response.KeyResult;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.Collections;

import static org.junit.Assert.*;

public class ApiAxleClientTest extends JerseyTest {

    private final ApiAxleClient client = new ApiAxleClient("http://localhost", 3001, "v1");

    @Override
    protected Application configure() {
        forceSet(TestProperties.CONTAINER_PORT, "3001");
        return new ResourceConfig(MockApiResource.class)
                .register(JacksonFeature.class);
    }

    @Test
    public void shouldGetApi() {
        ApiResult api = client.getApi("testapi");
        assertEquals("lolz.google.com", api.getEndPoint());
        assertEquals("http", api.getProtocol());
    }

    @Test
    public void shouldDeleteApi() {
        assertTrue(client.deleteApi("testapi"));
    }

    @Test
    public void shouldCreateKey() {
        KeyResult keyResult = client.createKey("test", KeyRequest.builder(5, 50, 500).build());
//        assertEquals(new Dat, keyResult.getCreatedAt());
        assertNull(keyResult.getUpdatedAt());
        assertEquals(5, keyResult.getQpd());
        assertEquals(50, keyResult.getQpm());
        assertEquals(100, keyResult.getQps());
        assertFalse(keyResult.getDisabled());
        assertFalse(keyResult.getAllApis());
        assertEquals("lompa", keyResult.getSharedSecret());
        assertNull(keyResult.getApis()); //TODO: remove getApis?
    }

    @Test
    public void shouldGetKey() {
        KeyResult keyResult = client.getKey("test");
//        assertEquals(new Dat, keyResult.getCreatedAt());
        assertNull(keyResult.getUpdatedAt());
        assertEquals(5, keyResult.getQpd());
        assertEquals(50, keyResult.getQpm());
        assertEquals(100, keyResult.getQps());
        assertFalse(keyResult.getDisabled());
        assertFalse(keyResult.getAllApis());
        assertEquals("lompa", keyResult.getSharedSecret());
        assertEquals(Collections.singletonList("lolz"), keyResult.getApis());
    }
}
