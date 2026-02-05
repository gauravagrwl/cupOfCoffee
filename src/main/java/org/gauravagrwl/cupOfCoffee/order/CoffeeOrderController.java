package org.gauravagrwl.cupOfCoffee.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// CoffeeOrderController.java (Level 0)

@RestController
public class CoffeeOrderController {
    @PostMapping("/order")
    public String orderCoffee(@RequestBody CoffeeOrder coffeeOrder) {
        // In a real-world application, here we would process the order
        return "Coffee order received for " + coffeeOrder.getCoffeeType();
    }
}
