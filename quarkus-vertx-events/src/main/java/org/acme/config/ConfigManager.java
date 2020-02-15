package org.acme.config;


import io.quarkus.vertx.ConsumeEvent;
import org.acme.config.events.ReloadConfigEvent;
import org.acme.config.events.ReloadConfigEvents;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


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

    // The following method is commented out since
    // although the codec is being registered to the event bus at startup (see Config's onStart),
    // that registration happens after EventBusCodecProcessor initialization who fails
    // the entire Quarkus startup.

//    @ConsumeEvent(Config.EBA_CONFIG_RELOAD)
//    public String reload(List<ReloadConfigEvent> events) {
//
//        System.out.println(">>> ConfigManager > reload > Got events: " + events);
//        return "OK";
//    }

}
