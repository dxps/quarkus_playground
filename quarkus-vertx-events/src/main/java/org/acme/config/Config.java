package org.acme.config;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.Vertx;
import org.acme.config.events.ReloadConfigEventsCodec;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;


@ApplicationScoped
public class Config {

    @Inject
    Vertx vertx;

    /**
     * event bus address (EBA) for config reload
     */
    public static final String EBA_CONFIG_RELOAD = "config.reload";

    void onStart(@Observes StartupEvent event) {

        vertx.eventBus().registerCodec(new ReloadConfigEventsCodec());
        System.out.println(">>> Registered codec for List<ReloadConfigEvents>.");
    }

}
