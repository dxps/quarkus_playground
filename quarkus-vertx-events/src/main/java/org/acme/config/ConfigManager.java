package org.acme.config;

import javax.enterprise.context.ApplicationScoped;

import org.acme.config.events.ReloadConfigEvent;
import org.acme.config.events.ReloadConfigEvents;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class ConfigManager {

    @ConsumeEvent(Config.EBA_CONFIG_RELOAD)
    public String reload(ReloadConfigEvent event) {

        System.out.println(">>> ConfigManager > reload > Got event: " + event);
        return "OK";
    }

    @ConsumeEvent(Config.EBA_CONFIG_RELOAD)
    public String reload(ReloadConfigEvents events) {

        System.out.println(">>> ConfigManager > reload > Got events: " + events);
        return "OK";
    }

    // The following method is commented out since collections and arrays are not supported,
    // although the codec is being registered in the `@ConsumeEvent` annotation.

    //    @ConsumeEvent(value = Config.EBA_CONFIG_RELOAD, codec = ReloadConfigEventsCodec.class)
    //    public String reload(List<ReloadConfigEvent> events) {
    //
    //        System.out.println(">>> ConfigManager > reload > Got events: " + events);
    //        return "OK";
    //    }

}
