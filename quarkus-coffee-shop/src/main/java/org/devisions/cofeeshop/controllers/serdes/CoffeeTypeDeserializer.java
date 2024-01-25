package org.devisions.cofeeshop.controllers.serdes;

import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;
import jakarta.validation.ConstraintViolationException;
import org.devisions.cofeeshop.model.CoffeeType;

import java.lang.reflect.Type;

public class CoffeeTypeDeserializer implements JsonbDeserializer<CoffeeType> {

    @Override
    public CoffeeType deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {

        var value = parser.getValue().toString();
        value = value.substring(1, value.length()-1);
        try {
            return CoffeeType.valueOf(value);
        } catch (IllegalArgumentException iae) {
            System.err.println("[dbg] deserialize err: " + iae.getMessage());
            // FYI: This isn't catched by the `ConstraintViolationExceptionMapper`, but by the `GlobalErrorMapper`.
            throw new ConstraintViolationException("Provided 'type' has an invalid value", null);
        }
    }

}
