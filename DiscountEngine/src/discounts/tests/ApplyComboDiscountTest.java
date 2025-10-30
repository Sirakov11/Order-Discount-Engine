package discounts.tests;

import discounts.ApplyComboDiscount;
import models.Order;
import models.OrderItem;
import models.Product;

import java.util.List;
import java.util.Set;

public class ApplyComboDiscountTest {
    public static void main(String[] args) {
        System.out.println("Running ApplyComboDiscount test: ");
        try {
            Product a = new Product(3, "Coffee", 10.0, "$");
            Product b = new Product(4, "Milk", 5.0, "$");
            Order order = new Order(3, List.of(new OrderItem(a, 1), new OrderItem(b, 1))); // total 15
            new ApplyComboDiscount(Set.of("Coffee", "Milk"), 5).apply(order); // discount 5
            if (order.getTotal() != 10.0) {
                throw new RuntimeException("Expected total 10.0, got " + order.getTotal());
            }
            System.out.println("ApplyComboDiscount applies fixed discount when combo present");
        } catch (RuntimeException ex) {
            System.out.println("ApplyComboDiscount test failed: " + ex.getMessage());
        }
    }
}

