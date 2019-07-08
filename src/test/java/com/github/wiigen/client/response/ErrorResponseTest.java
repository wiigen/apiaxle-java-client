package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        String json = "{"
                + "  \"meta\": {"
                + "    \"version\": 1,"
                + "    \"status_code\": 200"
                + "  },"
                + "  \"results\": {"
                + "    \"error\": {"
                + "      \"type\": \"Test type\","
                + "      \"message\": \"Some error message\""
                + "    }"
                + "  }"
                + "}";

        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse errorResponse = mapper.readValue(json, ErrorResponse.class);

        assertEquals(1, errorResponse.getMeta().getVersion());
        assertEquals(200, errorResponse.getMeta().getStatusCode());
        assertEquals("Test type", errorResponse.getResults().getError().getType());
        assertEquals("Some error message", errorResponse.getResults().getError().getMessage());
    }

}