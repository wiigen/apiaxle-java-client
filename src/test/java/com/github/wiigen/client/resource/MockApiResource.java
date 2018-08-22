package com.github.wiigen.client.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.wiigen.client.domain.ApiDetails;

@Path("v1/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MockApiResource {

    @POST
    @Path("{name}")
    public ApiDetails createApi(@PathParam("name") String apiName, ApiDetails apiDetails) {
        return apiDetails;
    }

    @DELETE
    @Path("{name}")
    public boolean deleteApi(@PathParam("name") String apiName) {
        return true;
    }

}
