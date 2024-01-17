package org.devisions.cofeeshop;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
public class CoffesOrdersResource {

    @GET
    @Path("/")
    public JsonArray orders() {
        // A programmatic JSON example.
        return Json.createArrayBuilder()
                .add(1)
                .add("Hello")
                .add(Json.createObjectBuilder()
                        .add("hello", "world")
                        .add("value", 123)
                )
                .build();
        // For custom mapping (although a `mapToJson(order)` method would be better):
        //        return List.of(new CoffeeOrder())
        //                .stream().map(o -> Json.createObjectBuilder()
        //                        .add("type", o.getType().name().toLowerCase())
        //                        .build()
        //                )
        //                .collect(JsonCollectors.toJsonArray());
    }

    @GET
    @Path("/{id}")
    public CoffeeOrder order(String id) {
        // A declarative JSON example.
        CoffeeOrder order = new CoffeeOrder();
        order.setType(CoffeeType.CAPPUCCINO);
        return order;
    }

}
