package com.github.wiigen.client.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GetKeysResponseTest {

    @Test
    public void shouldMapFromJson() throws Exception {
        String json = "{"
                + "  \"meta\": {"
                + "    \"version\": 1,"
                + "    \"status_code\": 200,"
                + "    \"pagination\": {"
                + "      \"next\": {"
                + "        \"href\": \"http://sample.com/v1/api/test/keys?from=11&to=21&resolve=false\","
                + "        \"from\": 11,"
                + "        \"to\": 21"
                + "      },"
                + "      \"prev\": {}"
                + "    }"
                + "  },"
                + "  \"results\": ["
                + "    \"key1\","
                + "    \"key2\","
                + "    \"key3\""
                + "  ]"
                + "}";

        ObjectMapper mapper = new ObjectMapper();
        GetKeysResponse getKeysResponse = mapper.readValue(json, GetKeysResponse.class);

        assertEquals(1, getKeysResponse.getMeta().getVersion());
        assertEquals(200, getKeysResponse.getMeta().getStatusCode());
        assertEquals("http://sample.com/v1/api/test/keys?from=11&to=21&resolve=false",
                getKeysResponse.getMeta().getPagination().getNext().getHref());
        assertEquals(11, getKeysResponse.getMeta().getPagination().getNext().getFrom());
        assertEquals(21, getKeysResponse.getMeta().getPagination().getNext().getTo());
        assertNull(getKeysResponse.getMeta().getPagination().getPrev().getHref());

        assertEquals(Arrays.asList("key1", "key2", "key3"), getKeysResponse.getResults());
    }

}