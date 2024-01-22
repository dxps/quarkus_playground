package org.devisions.cofeeshop.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.devisions.cofeeshop.model.CoffeeOrder;

import java.util.UUID;

@ApplicationScoped
public class CoffeeOrdersRepo implements PanacheRepositoryBase<CoffeeOrder, String> {
}
