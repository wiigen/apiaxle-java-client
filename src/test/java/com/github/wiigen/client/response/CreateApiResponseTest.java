package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateApiResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        String json = "{"
                + "  \"meta\": {"
                + "    \"version\": 1,"
                + "    \"status_code\": 200"
                + "  },"
                + "  \"results\": {"
                + "    \"endPoint\":\"graph.facebook.com\","
                + "    \"keylessQpd\":172800,"
                + "    \"keylessQpm\":120,"
                + "    \"keylessQps\":2,"
                + "    \"qpd\":172800,"
                + "    \"qpm\":-1,"
                + "    \"qps\":2"
                + "  }"
                + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        CreateApiResponse createApiResponse = objectMapper.readValue(json, CreateApiResponse.class);

        assertEquals(1, createApiResponse.getMeta().getVersion());
        assertEquals(200, createApiResponse.getMeta().getStatusCode());

        assertEquals("graph.facebook.com", createApiResponse.getResults().getEndPoint());
        assertEquals(172800, createApiResponse.getResults().getKeylessQpd());
        assertEquals(120, createApiResponse.getResults().getKeylessQpm());
        assertEquals(2, createApiResponse.getResults().getKeylessQps());
        assertEquals(172800, createApiResponse.getResults().getQpd());
        assertEquals(-1, createApiResponse.getResults().getQpm());
        assertEquals(2, createApiResponse.getResults().getQps());

        assertFalse(createApiResponse.getResults().getCorsEnabled());

        assertNull(createApiResponse.getResults().getDefaultPath());
    }
}