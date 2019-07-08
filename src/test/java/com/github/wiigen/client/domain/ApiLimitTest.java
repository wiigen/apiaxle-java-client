package com.github.wiigen.client.domain;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ApiLimitTest {

    @Test
    public void shouldReturnName() {
        ApiLimit api1 = ApiLimit.builder("api1")
                .qpd(5)
                .build();

        assertEquals("api1", api1.getName());
        assertEquals(5, api1.getQpd().intValue());
        assertNull(api1.getQpm());
        assertNull(api1.getQps());
    }

    @Test
    public void shouldReturnApiLimitsAsMap() {
        ApiLimit api1 = ApiLimit.builder("api1")
                .qpd(5)
                .build();

        Map<String, Integer> limitsAsMap = api1.getLimitsAsMap();
        assertEquals(5, limitsAsMap.get("qpd").intValue());
    }
}