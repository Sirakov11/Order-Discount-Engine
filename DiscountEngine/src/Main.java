import models. *;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Product coffee = new Product(1, "Coffee", 15.0, "$");
        Product milk = new Product(2, "Milk", 10.0, "$");
        Product tea = new Product(3, "Tea", 5.0, "$");
        Product tiramisu = new Product(3, "Tiramisu", 7.0, "$");
        Product baklava = new Product(3, "Baklava", 6.0, "$");

        List <OrderItem> items = List.of(
                new OrderItem(coffee, 3),
                new OrderItem(milk, 2),
                new OrderItem(tea, 4),
                new OrderItem(tiramisu, 3),
                new OrderItem(baklava, 5)
        );

        Order order = new Order(1, items);

        Set<Discount> discounts = new HashSet<>();
        discounts.add(new OrderByValue());
        discounts.add( new BuyXgetYFree("Tea", 3, 1));

        CheckoutService checkout = new CheckoutService(discounts);
        checkout.checkout(order);

        System.out.println("First total: $" + (order.getTotal() + order.getDiscountApplied()));
        System.out.println("Discount applied: $" + order.getDiscountApplied());
        System.out.println("Final total: $" + order.getTotal());

    }
}

//