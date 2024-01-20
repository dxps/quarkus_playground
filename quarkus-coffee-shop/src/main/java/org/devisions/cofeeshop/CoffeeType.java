package org.devisions.cofeeshop;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import org.devisions.cofeeshop.serdes.CoffeeTypeDeserializer;

@JsonbTypeDeserializer(CoffeeTypeDeserializer.class)
public enum CoffeeType {

    CAPPUCCINO,

    EXPRESSO,

    FILTER;

}
