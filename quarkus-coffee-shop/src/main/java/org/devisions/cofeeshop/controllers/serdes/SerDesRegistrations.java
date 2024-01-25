package org.devisions.cofeeshop.controllers.serdes;

import io.quarkus.jsonb.JsonbConfigCustomizer;
import jakarta.inject.Singleton;
import jakarta.json.bind.JsonbConfig;

@Singleton
public class SerDesRegistrations implements JsonbConfigCustomizer {

    @Override
    public void customize(JsonbConfig config) {
        config.withDeserializers(new CoffeeTypeDeserializer());
        config.withSerializers(new InstantTimestampSerializer());
    }

}
