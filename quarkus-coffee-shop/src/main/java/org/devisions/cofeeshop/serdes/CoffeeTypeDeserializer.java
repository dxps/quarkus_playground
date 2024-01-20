package org.devisions.cofeeshop.serdes;

import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;
import jakarta.validation.ConstraintViolationException;
import org.devisions.cofeeshop.CoffeeType;

import java.lang.reflect.Type;

public class CoffeeTypeDeserializer implements JsonbDeserializer<CoffeeType> {

    @Override
    public CoffeeType deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {

        var value = parser.getValue();
        try {
            return CoffeeType.valueOf(value.toString());
        } catch (IllegalArgumentException iae) {
            // Provided value cannot be deserialized as CoffeeType.
            // FYI: This isn't catched by the `ConstraintViolationExceptionMapper`,
            //      but by the `GlobalErrorMapper`.
            throw new ConstraintViolationException("Provided 'type' has an invalid value", null);
        }
    }

}
