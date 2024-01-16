package com.acme.restclient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/my-resource")
public class MyResource {

    @Inject
    MyService myService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ServerResponse hello() {
        ServerResponse serverResponse = myService.get();
        System.out.printf(">>> MyResource > Result: %s\n", serverResponse);
        return serverResponse;
    }

}
