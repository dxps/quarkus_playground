package org.devisions.cofeeshop.controllers.serdes;

import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

import java.time.Instant;

public class InstantTimestampSerializer implements JsonbSerializer<Instant> {

    @Override
    public void serialize(Instant obj, JsonGenerator generator, SerializationContext ctx) {
        generator.write(obj.getEpochSecond());
    }

}
