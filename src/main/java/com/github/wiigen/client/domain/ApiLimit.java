package com.github.wiigen.client.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
public class ApiLimit {
    private final String name;
    private final Integer qpd;
    private final Integer qpm;
    private final Integer qps;

    private ApiLimit(String name, Integer qpd, Integer qpm, Integer qps) {
        this.name = name;
        this.qpd = qpd;
        this.qpm = qpm;
        this.qps = qps;
    }

    /**
     * Create a ApiLimitBuilder to specify limits for a API.
     *
     * @param name name of the api.
     * @return a new ApiLimitBuilder.
     */
    public static ApiLimitBuilder builder(String name) {
        return new ApiLimitBuilder(name);
    }

    public String getName() {
        return name;
    }

    public Integer getQpd() {
        return qpd;
    }

    public Integer getQpm() {
        return qpm;
    }

    public Integer getQps() {
        return qps;
    }

    public static class ApiLimitBuilder {
        private final String name;
        private Integer qpd;
        private Integer qpm;
        private Integer qps;

        ApiLimitBuilder(String name) {
            this.name = name;
        }

        /**
         * Number of queries that can be called per day.
         *
         * @param qpd number of queries that can be called per day. Set to <code>-1</code> for no limit.
         * @return updated ApiLimitBuilder.
         */
        public ApiLimitBuilder qpd(int qpd) {
            this.qpd = qpd;
            return this;
        }

        /**
         * Number of queries that can be called per minute.
         *
         * @param qpm number of queries that can be called per minute. Set to <code>-1</code> for no limit.
         * @return updated ApiLimitBuilder.
         */
        public ApiLimitBuilder qpm(int qpm) {
            this.qpm = qpm;
            return this;
        }

        /**
         * Number of queries that can be called per second.
         *
         * @param qps number of queries that can be called per second. Set to <code>-1</code> for no limit.
         * @return updated ApiLimitBuilder.
         */
        public ApiLimitBuilder qps(int qps) {
            this.qps = qps;
            return this;
        }

        /**
         * Build a ApiLimit, using the supplied values in order to use it with
         * {@link com.github.wiigen.client.domain.KeyRequest.KeyRequestBuilder#apiLimts(List)}.
         *
         * @return the ApiLimit built from the ApiLimitBuilder.
         */
        public ApiLimit build() {
            return new ApiLimit(name, qpd, qpm, qps);
        }
    }

    Map<String, Integer> getLimitsAsMap() {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        if (qpd != null) {
            map.put("qpd", qpd);
        }
        if (qpm != null) {
            map.put("qpm", qpm);
        }
        if (qps != null) {
            map.put("qps", qps);
        }
        return map;
    }

}
