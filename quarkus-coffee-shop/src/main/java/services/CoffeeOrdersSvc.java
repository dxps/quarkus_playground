package services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.devisions.cofeeshop.model.CoffeeOrder;
import org.devisions.cofeeshop.repositories.CoffeeOrdersRepo;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CoffeeOrdersSvc {

    @Inject
    CoffeeOrdersRepo coffeeOrdersRepo;

    public List<CoffeeOrder> getAlls() {
        return coffeeOrdersRepo.listAll();
    }

    public Optional<CoffeeOrder> getById(String id) {
        return coffeeOrdersRepo.findByIdOptional(id);
    }

    @Transactional
    public CoffeeOrder create(CoffeeOrder order) {

        var newOrder = new CoffeeOrder(order.getType());
        coffeeOrdersRepo.persist(newOrder);
        return newOrder;
    }


}
