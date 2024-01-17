package org.devisions.cofeeshop;

import jakarta.json.bind.annotation.JsonbTypeSerializer;

import java.time.Instant;


public class CoffeeOrder {

    @JsonbTypeSerializer(InstantTimestampSerializer.class)
    private Instant createdAt;
    private CoffeeType type;

    public CoffeeOrder() {
        this.createdAt = Instant.now();
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public CoffeeType getType() {
        return type;
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

}
