package org.devisions.cofeeshop.model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.devisions.cofeeshop.controllers.serdes.InstantTimestampSerializer;
import org.devisions.cofeeshop.controllers.serdes.CoffeeTypeDeserializer;
import org.devisions.cofeeshop.utils.NanoId;

import java.time.Instant;


@Setter
@Getter
@ToString
@Entity
@Table(name = "orders")
public class CoffeeOrder {

    @Id
    @Size(max = 21)
    @Column(length = 21, nullable = false)
    @JsonbProperty("id")
    private String uuid;

    @Column(name = "created_at")
    @JsonbTypeSerializer(InstantTimestampSerializer.class)
    private Instant createdAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonbTypeDeserializer(CoffeeTypeDeserializer.class)
    private CoffeeType type;

    public CoffeeOrder() {
        // default constructor, needed by Hibernate.
    }

    public CoffeeOrder(CoffeeType type) {
        this.uuid = NanoId.randomNanoId();
        this.type = type;
        this.createdAt = Instant.now();
    }

}
