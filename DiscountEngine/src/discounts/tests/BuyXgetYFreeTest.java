package discounts.tests;

import discounts.BuyXgetYFree;
import models.Order;
import models.OrderItem;
import models.Product;

import java.util.List;

public class BuyXgetYFreeTest {
    public static void main(String[] args) {
        System.out.println("Running BuyXgetYFree test: ");
        try {
            Product p = new Product(2, "Tea", 10.0, "$");
            Order order = new Order(2, List.of(new OrderItem(p, 4))); // total 40
            new BuyXgetYFree("Tea", 3, 1).apply(order); // 1 free -> discount 10
            if (order.getTotal() != 30.0) {
                throw new RuntimeException("Expected total 30.0, got " + order.getTotal());
            }
            System.out.println("BuyXgetYFree gives correct free items discount");
        } catch (RuntimeException ex) {
            System.out.println("BuyXgetYFree test failed: " + ex.getMessage());
        }
    }
}


