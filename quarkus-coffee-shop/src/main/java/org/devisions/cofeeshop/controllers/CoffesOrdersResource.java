package org.devisions.cofeeshop.controllers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.stream.JsonCollectors;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.devisions.cofeeshop.model.CoffeeOrder;
import services.CoffeeOrdersSvc;

import java.util.List;

@ApplicationScoped
@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoffesOrdersResource {

    @Inject
    CoffeeOrdersSvc coffeeOrdersSvc;

    @GET
    @Path("/")
    public JsonArray getAll() {

        List<CoffeeOrder> orders = coffeeOrdersSvc.getAlls();
        return orders.stream()
                .map(this::mapToJson)
                .collect(JsonCollectors.toJsonArray());
    }

    @GET
    @Path("/{id}")
    public CoffeeOrder get(String id) {
        var res = coffeeOrdersSvc.getById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException();
        }
    }

    @POST
    public CoffeeOrder create(@Valid @NotNull CoffeeOrder order) {

        return coffeeOrdersSvc.create(order);
    }

    private JsonObject mapToJson(CoffeeOrder order) {

        // This is just an example of a programmatic way of creating a JSON object,
        // to be returned as an API response. It's not mandatory to do it like that.
        // `getAll()` method could just return the list of orders, without any processing like this.
        return Json.createObjectBuilder()
                .add("id", order.getUuid())
                .add("type", order.getType().name().toLowerCase())
                .add("createdAt", order.getCreatedAt().toString())
                .build();
    }

}
