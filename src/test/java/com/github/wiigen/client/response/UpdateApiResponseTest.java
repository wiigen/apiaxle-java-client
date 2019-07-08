package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UpdateApiResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        Date updatedAt = new Date();
        String json = "{"
                + "  \"meta\": {"
                + "    \"version\": 1,"
                + "    \"status_code\": 200"
                + "  },"
                + "  \"results\": {"
                + "    \"old\": {"
                + "      \"endPoint\":\"graph.facebook.com\","
                + "      \"keylessQps\":2,"
                + "      \"keylessQpm\":120,"
                + "      \"keylessQpd\":172800,"
                + "      \"qps\":2,"
                + "      \"qpm\":-1,"
                + "      \"qpd\":172800"
                + "    }, \"new\": {"
                + "      \"updatedAt\": " + updatedAt.getTime() + ","
                + "      \"endPoint\":\"graph2.facebook.com\","
                + "      \"keylessQps\":2,"
                + "      \"keylessQpm\":120,"
                + "      \"keylessQpd\":172800,"
                + "      \"qps\":2,"
                + "      \"qpm\":-1,"
                + "      \"qpd\":172800"
                + "    }"
                + "  }"
                + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        UpdateApiResponse updateApiResponse = objectMapper.readValue(json, UpdateApiResponse.class);

        assertEquals(1, updateApiResponse.getMeta().getVersion());
        assertEquals(200, updateApiResponse.getMeta().getStatusCode());

        assertEquals("graph.facebook.com", updateApiResponse.getResults().getOldApi().getEndPoint());
        assertEquals(172800, updateApiResponse.getResults().getOldApi().getKeylessQpd());
        assertEquals(120, updateApiResponse.getResults().getOldApi().getKeylessQpm());
        assertEquals(2, updateApiResponse.getResults().getOldApi().getKeylessQps());
        assertEquals(172800, updateApiResponse.getResults().getOldApi().getQpd());
        assertEquals(-1, updateApiResponse.getResults().getOldApi().getQpm());
        assertEquals(2, updateApiResponse.getResults().getOldApi().getQps());

        assertEquals(updatedAt, updateApiResponse.getResults().getNewApi().getUpdatedAt());
        assertEquals("graph2.facebook.com", updateApiResponse.getResults().getNewApi().getEndPoint());
        assertEquals(172800, updateApiResponse.getResults().getNewApi().getKeylessQpd());
        assertEquals(120, updateApiResponse.getResults().getNewApi().getKeylessQpm());
        assertEquals(2, updateApiResponse.getResults().getNewApi().getKeylessQps());
        assertEquals(172800, updateApiResponse.getResults().getNewApi().getQpd());
        assertEquals(-1, updateApiResponse.getResults().getNewApi().getQpm());
        assertEquals(2, updateApiResponse.getResults().getNewApi().getQps());
    }
}