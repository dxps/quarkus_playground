package com.acme.restclient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
@RegisterRestClient
public interface MyClient {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    ServerResponse get(@BeanParam MyClientOptions options);

}
