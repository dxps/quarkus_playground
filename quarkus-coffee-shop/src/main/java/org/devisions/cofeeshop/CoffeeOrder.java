package org.devisions.cofeeshop;

import jakarta.json.bind.annotation.JsonbTypeSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Setter
@Getter
public class CoffeeOrder {

    @JsonbTypeSerializer(InstantTimestampSerializer.class)
    private Instant createdAt;
    private CoffeeType type;

    public CoffeeOrder() {
        this.createdAt = Instant.now();
        this.type = CoffeeType.FILTER;
    }

}
