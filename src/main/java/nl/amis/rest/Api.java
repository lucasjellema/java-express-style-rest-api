package nl.amis.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

@Path("api")
public class Api {

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String postApiMessage(@Context Request request, String json) {
        System.out.println("received event:" + json);
        return "post message received " + json;
    }

    @GET
    @Produces("text/plain")
    public String getApiMessage(@Context Request request) {
        return "nothing to report from getApiMessage.";
    }

}