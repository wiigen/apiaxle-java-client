package com.github.wiigen.client;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import com.github.wiigen.client.domain.ApiDetails;
import com.github.wiigen.client.resource.MockApiResource;

public class ApiAxleClientTest extends JerseyTest {

    private final ApiAxleClient client = new ApiAxleClient("http://localhost", 3001, "v1");

    @Override
    protected Application configure() {
        forceSet(TestProperties.CONTAINER_PORT, "3001");
        return new ResourceConfig(MockApiResource.class)
                .register(JacksonFeature.class);
    }

    @Test
    public void shouldCreateApi() {
        ApiDetails api = new ApiDetails();
        assertEquals(api, client.createApi("testapi", api));
    }

    @Test
    public void shouldDeleteApi() {
        assertTrue(client.deleteApi("testapi"));
    }
}
