package org.gauravagrwl.cupOfCoffee.order;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coffees")
public class CoffeeController_Level3 {
    private List<String> availableCoffees = new ArrayList<>();

    public CoffeeController_Level3() {
        availableCoffees.add("Espresso");
        availableCoffees.add("Latte");
        availableCoffees.add("Cappuccino");
        availableCoffees.add("Americano");
    }

    @GetMapping
    public List<EntityModel<String>> getCoffees() {
        List<EntityModel<String>> resources = new ArrayList<>();
        for (String coffee : availableCoffees) {
            EntityModel<String> resource = EntityModel.of(coffee);
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CoffeeController_Level3.class).getCoffees()).withSelfRel();
            resource.add(selfLink);
            resources.add(resource);
        }
        return resources;
    }

    @PostMapping
    public String orderCoffee(@RequestBody CoffeeOrder coffeeOrder) {
        return "Coffee order received for " + coffeeOrder.getCoffeeType();
    }

}
