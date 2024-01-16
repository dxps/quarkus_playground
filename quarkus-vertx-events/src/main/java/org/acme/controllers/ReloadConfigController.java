package org.acme.controllers;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.config.Config;
import org.acme.config.events.ReloadConfigEvent;

import io.vertx.axle.core.eventbus.EventBus;
import io.vertx.axle.core.eventbus.Message;

@Path("/config/reload")
public class ReloadConfigController {

    @Inject
    EventBus eventBus;

    @GET
    @Path("/section/{section}")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> reloadSection(@PathParam("section") String section) {

        System.out.println(">>> ReloadConfigController > reloadSection > Handling request: " + section);
        var event = ReloadConfigEvent.valueOf(section.toUpperCase());

        // .send() is deprecated.
        // return eventBus.<String>send(Config.EBA_CONFIG_RELOAD, event)
        return eventBus.<String>request(Config.EBA_CONFIG_RELOAD, event)
                .thenApply(Message::body);

    }

    /**
     * `sections` value should be a comma separated list of entries
     */
    @GET
    @Path("/sections{sections}")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> reloadSections(@PathParam("sections") String section) {

        System.out.println(">>> ReloadConfigController > reloadSection > Handling request: " + section);
        var event = ReloadConfigEvent.valueOf(section.toUpperCase());

        // .send() is deprecated.
        // return eventBus.<String>send(Config.EBA_CONFIG_RELOAD, event)
        return eventBus.<String>request(Config.EBA_CONFIG_RELOAD, event)
                .thenApply(Message::body);

    }

}
