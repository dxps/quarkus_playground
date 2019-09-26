package org.devisions.quarkus.hello;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/hello")
public class HelloResource {

    @Inject HelloService helloSvc;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public String hello() {
        return helloSvc.hello();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String hello(@PathParam("name") String name) {
        return helloSvc.hello(name);
    }

    // Async examples

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/async")
    public CompletionStage<String> helloAsync() {
        return helloSvc.helloAsync();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/async/{name}")
    public CompletionStage<String> helloAsync(@PathParam("name") String name) {
        return helloSvc.helloAsync(name);
    }

}
