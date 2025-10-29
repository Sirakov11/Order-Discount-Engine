package discounts.tests;

import discounts.OrderByValue;
import models.Order;
import models.OrderItem;
import models.Product;

import java.util.List;

public class OrderByValueTest {
    public static void main(String[] args) {
        System.out.println("Running OrderByValue test: ");
        try {
            Product p = new Product(1, "Item", 200.0, "$");
            Order order = new Order(1, List.of(new OrderItem(p, 1)));
            new OrderByValue().apply(order);
            if (order.getTotal() != 180.0) {
                throw new RuntimeException("Expected total 180.0, got " + order.getTotal());
            }
            System.out.println("OrderByValue applies 10% over 100");
        } catch (RuntimeException ex) {
            System.out.println("OrderByValue test failed: " + ex.getMessage());
        }
    }
}


