import models.*;
import discounts.BuyXgetYFree;
import discounts.OrderByValue;
import discounts.ApplyComboDiscount;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter currency symbol: ");
        String currency = scanner.nextLine().trim();

        System.out.println("How many different products are in the order?");
        int numItems = readInt(scanner, "Please enter a valid integer for number of products:");

        List<OrderItem> items = new ArrayList<>();
        for (int i = 1; i <= numItems; i++) {
            System.out.println("Product " + i + " name:");
            String name = scanner.nextLine().trim();

            System.out.println("Product " + i + " price (number):");
            double price = readDouble(scanner, "Please enter a valid number for price:");

            System.out.println("Quantity for " + name + ":");
            int qty = readInt(scanner, "Please enter a valid integer for quantity:");

            Product p = new Product(i, name, price, currency);
            items.add(new OrderItem(p, qty));
        }

        Order order = new Order(1, items);

        Set<Discount> discounts = new HashSet<>();

        discounts.add(new OrderByValue());

        discounts.add(new BuyXgetYFree("Coffee", 2, 1));

        Set<String> combo = Set.of("Coffee", "Milk");
        discounts.add(new ApplyComboDiscount(combo, 2.0));

        CheckoutService checkout = new CheckoutService(discounts);
        checkout.checkout(order);

        System.out.println("\n--- ORDER SUMMARY ---");
        System.out.println("First total: " + currency + (order.getTotal() + order.getDiscountApplied()));
        System.out.println("Discount applied: " + currency + order.getDiscountApplied());
        System.out.println("Final total: " + currency + order.getTotal());

        scanner.close();
    }

    private static int readInt(Scanner scanner, String retryPrompt) {
        while (true) {
            String line = scanner.nextLine();
            if (line != null) {
                line = line.trim();
            }
            if (line != null && !line.isEmpty()) {
                try {
                    return Integer.parseInt(line);
                } catch (NumberFormatException ignored) {
                }
            }
            System.out.println(retryPrompt);
        }
    }

    private static double readDouble(Scanner scanner, String retryPrompt) {
        while (true) {
            String line = scanner.nextLine();
            if (line != null) {
                line = line.trim();
            }
            if (line != null && !line.isEmpty()) {
                try {
                    return Double.parseDouble(line);
                } catch (NumberFormatException ignored) {
                }
            }
            System.out.println(retryPrompt);
        }
    }
}
