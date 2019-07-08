package com.github.wiigen.client.resource;

import com.github.wiigen.client.domain.ApiRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MockApiResource {

    @POST
    @Path("api/{name}")
    public String createApi(@PathParam("name") String apiName, String ignore) {
        return "{\n" +
                "  \"meta\": {\n" +
                "    \"version\": 1,\n" +
                "    \"status_code\": 200\n" +
                "  },\n" +
                "  \"results\": {\n" +
                "    \"protocol\": \"http\",\n" +
                "    \"tokenSkewProtectionCount\": 3,\n" +
                "    \"apiFormat\": \"json\",\n" +
                "    \"endPointTimeout\": 2,\n" +
                "    \"disabled\": false,\n" +
                "    \"strictSSL\": true,\n" +
                "    \"sendThroughApiKey\": false,\n" +
                "    \"sendThroughApiSig\": false,\n" +
                "    \"hasCapturePaths\": false,\n" +
                "    \"allowKeylessUse\": false,\n" +
                "    \"keylessQps\": 2,\n" +
                "    \"keylessQpm\": 120,\n" +
                "    \"keylessQpd\": 172800,\n" +
                "    \"qps\": 2,\n" +
                "    \"qpm\": -1,\n" +
                "    \"qpd\": 172800,\n" +
                "    \"corsEnabled\": false,\n" +
                "    \"endPoint\": \"lolz.google.com\",\n" +
                "    \"createdAt\": 1543351723639\n" +
                "  }\n" +
                "}";
    }

    @GET
    @Path("api/{name}")
    public String getApi() {
        return "{\n" + 
                "  \"meta\": {\n" + 
                "    \"version\": 1,\n" + 
                "    \"status_code\": 200\n" + 
                "  },\n" + 
                "  \"results\": {\n" + 
                "    \"protocol\": \"http\",\n" + 
                "    \"tokenSkewProtectionCount\": 3,\n" + 
                "    \"apiFormat\": \"json\",\n" +
                "    \"endPointTimeout\": 2,\n" + 
                "    \"disabled\": false,\n" + 
                "    \"strictSSL\": true,\n" + 
                "    \"sendThroughApiKey\": false,\n" + 
                "    \"sendThroughApiSig\": false,\n" + 
                "    \"hasCapturePaths\": false,\n" + 
                "    \"allowKeylessUse\": false,\n" + 
                "    \"keylessQps\": 2,\n" + 
                "    \"keylessQpm\": 120,\n" + 
                "    \"keylessQpd\": 172800,\n" + 
                "    \"qps\": 2,\n" + 
                "    \"qpm\": -1,\n" + 
                "    \"qpd\": 172800,\n" + 
                "    \"corsEnabled\": false,\n" + 
                "    \"endPoint\": \"lolz.google.com\",\n" + 
                "    \"createdAt\": 1543351723639\n" + 
                "  }\n" + 
                "}";
    }

    @PUT
    @Path("api/{name}")
    public String updateApi(@PathParam("name") String apiName, ApiRequest apiRequest) {
        return "{\n" +
                "  \"meta\": {\n" +
                "    \"version\": 1,\n" +
                "    \"status_code\": 200\n" +
                "  },\n" +
                "  \"results\": {\n" +
                "    \"new\": {\n" +
                "      \"protocol\": \"http\",\n" +
                "      \"tokenSkewProtectionCount\": 3,\n" +
                "      \"apiFormat\": \"json\",\n" +
                "      \"endPointTimeout\": 2,\n" +
                "      \"disabled\": false,\n" +
                "      \"strictSSL\": true,\n" +
                "      \"sendThroughApiKey\": false,\n" +
                "      \"sendThroughApiSig\": false,\n" +
                "      \"hasCapturePaths\": false,\n" +
                "      \"allowKeylessUse\": false,\n" +
                "      \"keylessQps\": 2,\n" +
                "      \"keylessQpm\": 120,\n" +
                "      \"keylessQpd\": 172800,\n" +
                "      \"qps\": 2,\n" +
                "      \"qpm\": -1,\n" +
                "      \"qpd\": 172800,\n" +
                "      \"corsEnabled\": true,\n" +
                "      \"endPoint\": \"lolz.google.com\",\n" +
                "      \"createdAt\": 1550002772283\n" +
                "    },\n" +
                "    \"old\": {\n" +
                "      \"protocol\": \"http\",\n" +
                "      \"tokenSkewProtectionCount\": 3,\n" +
                "      \"apiFormat\": \"json\",\n" +
                "      \"endPointTimeout\": 2,\n" +
                "      \"disabled\": false,\n" +
                "      \"strictSSL\": true,\n" +
                "      \"sendThroughApiKey\": false,\n" +
                "      \"sendThroughApiSig\": false,\n" +
                "      \"hasCapturePaths\": false,\n" +
                "      \"allowKeylessUse\": false,\n" +
                "      \"keylessQps\": 2,\n" +
                "      \"keylessQpm\": 120,\n" +
                "      \"keylessQpd\": 172800,\n" +
                "      \"qps\": 2,\n" +
                "      \"qpm\": -1,\n" +
                "      \"qpd\": 172800,\n" +
                "      \"corsEnabled\": false,\n" +
                "      \"endPoint\": \"lolz.google.com\",\n" +
                "      \"createdAt\": 1550002772283\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }

    @DELETE
    @Path("api/{name}")
    public String deleteApi(@PathParam("name") String apiName) {
        return "{ \"meta\": { \"version\": 1, \"status_code\": 200 }, \"results\": true }";
    }

    @POST
    @Path("key/{keyName}")
    public String createKey(@PathParam("keyName") String keyName, String ignore) {
        return "{\n" +
                "    \"meta\": {\n" +
                "        \"version\": 1,\n" +
                "        \"status_code\": 200\n" +
                "    },\n" +
                "    \"results\": {\n" +
                "        \"disabled\": false,\n" +
                "        \"sharedSecret\": \"lompa\",\n" +
                "        \"qpd\": 5,\n" +
                "        \"qpm\": 50,\n" +
                "        \"qps\": 100,\n" +
                "        \"apiLimits\": \"{\\\"lolz\\\":{\\\"qpd\\\":5000,\\\"qpm\\\":500,\\\"qps\\\":5}}\",\n" +
                "        \"allApis\": false,\n" +
                "        \"createdAt\": 1551599386606\n" +
                "    }\n" +
                "}";
    }

    @GET
    @Path("key/{keyName}")
    public String getKey(@PathParam("keyName") String keyName) {
        return "{\n" +
                "    \"meta\": {\n" +
                "      \"version\": 1,\n" +
                "      \"status_code\": 200\n" +
                "    },\n" +
                "    \"results\": {\n" +
                "        \"disabled\": false,\n" +
                "        \"sharedSecret\": \"lompa\",\n" +
                "        \"qpd\": 5,\n" +
                "        \"qpm\": 50,\n" +
                "        \"qps\": 100,\n" +
                "        \"apiLimits\": \"{\\\"lolz\\\":{\\\"qpd\\\":5000,\\\"qpm\\\":500,\\\"qps\\\":5}}\",\n" +
                "        \"allApis\": false,\n" +
                "        \"createdAt\": 1551599386606,\n" +
                "        \"apis\": [\n" +
                "            \"lolz\"\n" +
                "        ]\n" +
                "    }\n" +
                "}";
    }

}
