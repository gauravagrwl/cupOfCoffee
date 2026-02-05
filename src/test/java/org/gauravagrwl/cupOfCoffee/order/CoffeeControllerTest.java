package org.gauravagrwl.cupOfCoffee.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Unit tests for the CoffeeController class.
 */
@SpringBootTest
public class CoffeeControllerTest {

    @Autowired
    private CoffeeController coffeeController;

    private MockMvc mockMvc;

    /**
     * Setup method to initialize the MockMvc instance before each test.
     */
    @BeforeEach
    public void setup() {
        mockMvc = standaloneSetup(coffeeController).build();
    }

    /**
     * Test the GET /coffees endpoint.
     * It should return the list of available coffee types.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void testGetCoffees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/coffees"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("Espresso"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].content").value("Latte"));
    }

    /**
     * Test the POST /order endpoint.
     * It should place an order for a coffee and return a confirmation message.
     *
     * @throws Exception if the test fails
     */
        @Test
        public void testOrderCoffee() throws Exception {
            String coffeeOrderJson = "{\"coffeeType\":\"Latte\",\"size\":\"Medium\"}";

            mockMvc.perform(MockMvcRequestBuilders.post("/order")
                            .contentType("application/json")
                            .content(coffeeOrderJson))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("Coffee order received for Latte in size Medium"));
        }
    }

