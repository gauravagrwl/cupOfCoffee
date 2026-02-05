package org.gauravagrwl.cupOfCoffee.order;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coffees")
public class CoffeeController_Level2 {
    private List<String> availableCoffees = new ArrayList<>();

    public CoffeeController_Level2() {
        availableCoffees.add("Espresso");
        availableCoffees.add("Latte");
        availableCoffees.add("Cappuccino");
        availableCoffees.add("Americano");
    }

    @GetMapping
    public List<String> getCoffees() {
        return availableCoffees;
    }

    @PostMapping
    public String orderCoffee(@RequestBody CoffeeOrder coffeeOrder) {
        // Add order to the system
        return "Coffee order received for " + coffeeOrder.getCoffeeType();
    }

    @PutMapping("/{coffeeType}")
    public String updateCoffee(@PathVariable String coffeeType) {
        // Update coffee type (e.g., size or other details)
        return coffeeType + " coffee has been updated.";
    }

    @DeleteMapping("/{coffeeType}")
    public String deleteCoffee(@PathVariable String coffeeType) {
        availableCoffees.remove(coffeeType);
        return coffeeType + " coffee has been deleted.";
    }
}