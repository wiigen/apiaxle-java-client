package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GetApisResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        String json = "{"
                + "  \"meta\": {"
                + "    \"version\": 1,"
                + "    \"status_code\": 200,"
                + "    \"pagination\": {}"
                + "  },"
                + "  \"results\": ["
                + "    \"api1\","
                + "    \"api2\","
                + "    \"api3\""
                + "  ]"
                + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        GetApisResponse getApisResponse = objectMapper.readValue(json, GetApisResponse.class);

        assertEquals(1, getApisResponse.getMeta().getVersion());
        assertEquals(200, getApisResponse.getMeta().getStatusCode());
        assertEquals(Arrays.asList("api1", "api2", "api3"), getApisResponse.getResults());
    }
}