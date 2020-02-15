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
        // This method is called when sending the events over the wire (network).
        // The List (2nd param) should be serialized into the Buffer (1st param).
        // The Buffer is what gets sent over the network to another JVM.
    }

    @Override
    public List<ReloadConfigEvent> decodeFromWire(int pos, Buffer buffer) {
        // TODO: to implement
        // This method is called when receiving the events from the wire (network).
        // The Buffer (2nd param) needs to be deserialized into the List that is returned.
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
