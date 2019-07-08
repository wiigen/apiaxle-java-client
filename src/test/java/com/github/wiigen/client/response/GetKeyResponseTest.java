package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GetKeyResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        String json = ""
                + "{\n"
                + "  \"meta\": {\n"
                + "    \"version\": 1,\n"
                + "    \"status_code\": 200\n"
                + "  },\n"
                + "  \"results\": {\n"
                + "    \"disabled\": false,\n"
                + "    \"qpd\": 5,\n"
                + "    \"qpm\": 50,\n"
                + "    \"qps\": 100,\n"
                + "    \"createdAt\": 1551560222198,\n"
                + "    \"apis\": [\n"
                + "      \"lolz\"\n"
                + "    ]\n"
                + "  }\n"
                + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        GetKeyResponse getKeyResponse = objectMapper.readValue(json, GetKeyResponse.class);

        assertEquals(1, getKeyResponse.getMeta().getVersion());
        assertEquals(200, getKeyResponse.getMeta().getStatusCode());

        assertFalse(getKeyResponse.getResults().getDisabled());
        assertEquals(5, getKeyResponse.getResults().getQpd());
        assertEquals(50, getKeyResponse.getResults().getQpm());
        assertEquals(100, getKeyResponse.getResults().getQps());

        assertEquals(Collections.singletonList("lolz"), getKeyResponse.getResults().getApis());
    }
}