package org.acme.config.events;

import java.util.ArrayList;
import java.util.List;

public class ReloadConfigEvents {

    public final List<ReloadConfigEvent> events = new ArrayList<>(2);

    public ReloadConfigEvents(List<ReloadConfigEvent> events) {
        this.events.addAll(events);
    }

}
