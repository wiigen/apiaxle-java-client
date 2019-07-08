package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CreateKeyResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        String json = "{"
                + "  \"meta\": {"
                + "    \"version\": 1,"
                + "    \"status_code\": 200"
                + "  },"
                + "  \"results\": {"
                + "    \"qpd\": 5,"
                + "    \"qpm\": 10,"
                + "    \"qps\": 20"
                + "  }"
                + "}";

        ObjectMapper mapper = new ObjectMapper();
        CreateKeyResponse createKeyResponse = mapper.readValue(json, CreateKeyResponse.class);

        assertEquals(1, createKeyResponse.getMeta().getVersion());
        assertEquals(200, createKeyResponse.getMeta().getStatusCode());

        assertEquals(5, createKeyResponse.getResults().getQpd());
        assertEquals(10, createKeyResponse.getResults().getQpm());
        assertEquals(20, createKeyResponse.getResults().getQps());
        assertNull(createKeyResponse.getResults().getApiLimits());
    }

}