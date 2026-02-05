package org.gauravagrwl.cupOfCoffee.order;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * REST controller for managing Coffee Orders.
 * Handles GET, POST, PUT, DELETE requests for coffee resources.
 */
@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    private List<String> availableCoffees = new ArrayList<>();

    /**
     * Constructor initializing a list of available coffee types.
     */
    public CoffeeController() {
        availableCoffees.add("Espresso");
        availableCoffees.add("Latte");
        availableCoffees.add("Cappuccino");
        availableCoffees.add("Americano");
    }

    /**
     * Endpoint to fetch all available coffee types.
     * @return a list of available coffee types with HATEOAS links.
     */
    @GetMapping
    public List<EntityModel<String>> getCoffees() {
        List<EntityModel<String>> resources = new ArrayList<>();
        for (String coffee : availableCoffees) {
            EntityModel<String> resource = EntityModel.of(coffee);
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CoffeeController.class).getCoffees()).withSelfRel();
            resource.add(selfLink);
            resources.add(resource);
        }
        return resources;
    }

    /**
     * Endpoint to place a new coffee order.
     * @param coffeeOrder the coffee order details
     * @return a response message confirming the coffee order
     */
    @PostMapping
    public String orderCoffee(@RequestBody CoffeeOrder coffeeOrder) {
        return "Coffee order received for " + coffeeOrder.getCoffeeType() + " in size " + coffeeOrder.getSize();
    }

    /**
     * Endpoint to update a coffee type.
     * @param coffeeType the coffee type to update
     * @return confirmation message
     */
    @PutMapping("/{coffeeType}")
    public String updateCoffee(@PathVariable String coffeeType) {
        return coffeeType + " coffee has been updated.";
    }

    /**
     * Endpoint to delete a coffee type.
     * @param coffeeType the coffee type to delete
     * @return confirmation message
     */
    @DeleteMapping("/{coffeeType}")
    public String deleteCoffee(@PathVariable String coffeeType) {
        availableCoffees.remove(coffeeType);
        return coffeeType + " coffee has been deleted.";
    }
}
