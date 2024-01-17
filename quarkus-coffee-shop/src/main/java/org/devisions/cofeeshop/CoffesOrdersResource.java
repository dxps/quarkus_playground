package org.devisions.cofeeshop;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
public class CoffesOrdersResource {

    @GET
    public CoffeeOrder order() {
        CoffeeOrder order = new CoffeeOrder();
        order.setType(CoffeeType.CAPPUCCINO);
        return order;
    }

}
