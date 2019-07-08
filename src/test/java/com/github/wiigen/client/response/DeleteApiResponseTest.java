package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteApiResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        String json = "{"
                + "  \"meta\": {"
                + "    \"version\": 1,"
                + "    \"status_code\": 200"
                + "  },"
                + "  \"results\": true"
                + "}";

        ObjectMapper mapper = new ObjectMapper();
        DeleteApiResponse deleteApiResponse = mapper.readValue(json, DeleteApiResponse.class);

        assertEquals(1, deleteApiResponse.getMeta().getVersion());
        assertEquals(200, deleteApiResponse.getMeta().getStatusCode());
        assertTrue(deleteApiResponse.getResults());
    }

}