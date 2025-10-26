import models.Order;
import models.OrderItem;

import java.util.Locale;
import java.util.Set;


public class DiscountEngine {
    public static void applyOrderValueDiscount(Order order){
        if (order.getTotal() > 100){
            double discount = order.getTotal() *0.10;
            order.applyDiscount(discount);
        }
    }

    public static void applyBuyXGetYFree(Order order, String productName, int buy, int free){
        for (OrderItem item : order.getItems()){
            String orderProduct = item.getProduct().getName();
            String targetProduct = productName;

            if (orderProduct.equals(targetProduct)){
                int groupSize = buy + free;
                int freeItems = (item.getQuantity() / groupSize) * free;
                double discount = freeItems * item.getProduct().getPrice();
                order.applyDiscount(discount);
            }
        }
    }
    public static void applyComboDiscount(Order order, Set<String> combo, double discountAmount){
        boolean hasAll = true;
        for (String comboItem : combo){
            boolean found = false;

            for (OrderItem orderItem : order.getItems()){

                String orderName = orderItem.getProduct().getName().toLowerCase();
                String comboName = comboItem.toLowerCase();
                if (orderName.equals(comboName)){
                    found = true;
                    break;
                }
            }
            if (!found){
                hasAll = false;
                break;
            }
        }
        if (hasAll){
            order.applyDiscount(discountAmount);
        }
    }
}

