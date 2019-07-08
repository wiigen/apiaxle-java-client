package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpdateKeyResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        String json = "{"
                + "  \"meta\": {"
                + "    \"version\": 1,"
                + "    \"status_code\": 200"
                + "  },"
                + "  \"results\": {"
                + "    \"old\": {\"qpd\":5,\"qpm\":10,\"qps\":50},"
                + "    \"new\": {\"qpd\":50,\"qpm\":100,\"qps\":5000}"
                + "  }"
                + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        UpdateKeyResponse updateKeyResponse = objectMapper.readValue(json, UpdateKeyResponse.class);

        assertEquals(1, updateKeyResponse.getMeta().getVersion());
        assertEquals(200, updateKeyResponse.getMeta().getStatusCode());

        assertEquals(5, updateKeyResponse.getResults().getOldKey().getQpd());
        assertEquals(10, updateKeyResponse.getResults().getOldKey().getQpm());
        assertEquals(50, updateKeyResponse.getResults().getOldKey().getQps());

        assertEquals(50, updateKeyResponse.getResults().getNewKey().getQpd());
        assertEquals(100, updateKeyResponse.getResults().getNewKey().getQpm());
        assertEquals(5000, updateKeyResponse.getResults().getNewKey().getQps());
    }
}