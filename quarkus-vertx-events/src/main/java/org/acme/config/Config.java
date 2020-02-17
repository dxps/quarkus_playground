package org.acme.config;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.Vertx;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

// import org.acme.config.events.ReloadConfigEventsCodec;


@ApplicationScoped
public class Config {

    @Inject
    Vertx vertx;

    /**
     * event bus address (EBA) for config reload
     */
    public static final String EBA_CONFIG_RELOAD = "config.reload";

    void onStart(@Observes StartupEvent event) {

        // No need to register the codec here. `@ConsumeEvent` provides an attribute for this.
        // vertx.eventBus().registerCodec(new ReloadConfigEventsCodec());
        // System.out.println(">>> Registered codec for List<ReloadConfigEvents>.");
    }

}
