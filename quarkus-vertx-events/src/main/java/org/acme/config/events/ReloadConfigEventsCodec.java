package org.acme.config.events;


import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

import java.util.List;

public class ReloadConfigEventsCodec implements MessageCodec<List<ReloadConfigEvent>, List<ReloadConfigEvent>> {

    @Override
    public List<ReloadConfigEvent> transform(List<ReloadConfigEvent> msg) {
        // This method is used for sending the message locally (within the same JVM).
        // Here we just return the reference.
        return msg;
    }

    @Override
    public void encodeToWire(Buffer buffer, List<ReloadConfigEvent> events) {
        // TODO: to implement
    }

    @Override
    public List<ReloadConfigEvent> decodeFromWire(int pos, Buffer buffer) {
        // TODO: to implement
        return null;
    }

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }

}
