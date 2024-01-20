package org.devisions.cofeeshop;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.validation.Valid;

@ApplicationScoped
@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoffesOrdersResource {

    @GET
    @Path("/")
    public JsonArray getAll() {
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
    public CoffeeOrder get(String id) {
        // A declarative JSON example.
        CoffeeOrder order = new CoffeeOrder();
        order.setType(CoffeeType.CAPPUCCINO);
        return order;
    }

    @POST
    public CoffeeOrder create(@Valid CoffeeOrder order) {
        System.out.printf("[create] Got order: %s\n", order);
        var newOrder = new CoffeeOrder();
        newOrder.setType(order.getType());
        return newOrder;
    }

}
