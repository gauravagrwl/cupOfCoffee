package org.gauravagrwl.cupOfCoffee.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//At Level 1, we introduce separate URIs for different resources (e.g., /coffees, /orders) but still use POST for interactions.
@RestController
public class CoffeeController_Level1 {
    @GetMapping("/coffees")
    public List<String> getCoffees() {
        // Return a list of available coffee types
        return Arrays.asList("Espresso", "Latte", "Cappuccino", "Americano");
    }

    @PostMapping("/order")
    public String orderCoffee(@RequestBody CoffeeOrder coffeeOrder) {
        // In a real-world application, here we would process the order
        return "Coffee order received for " + coffeeOrder.getCoffeeType();
    }
}
