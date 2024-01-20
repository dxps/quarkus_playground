package org.devisions.cofeeshop;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import org.devisions.cofeeshop.validations.EnumNamePattern;

import java.time.Instant;
import java.util.UUID;


@Setter
@Getter
@ToString
public class CoffeeOrder {

    @JsonbProperty("id")
    private UUID uuid;

    @JsonbTypeSerializer(InstantTimestampSerializer.class)
    private Instant createdAt;

    @NotNull
    // TODO: Doesn't work. During deserialization, it still throws an IllegalArgumentException
    // due to 'No enum constant org.devisions.cofeeshop.CoffeeType.some'
    // @EnumNamePattern(regexp = "CAPPUCCINO|EXPRESSO|FILTER")
    private CoffeeType type;

    public CoffeeOrder() {
        this.uuid = UUID.randomUUID();
        this.createdAt = Instant.now();
    }

}
