package discounts;

import models.Discount;
import models.Order;
import models.OrderItem;

import java.util.Set;

public class ApplyComboDiscount implements Discount {
    private final Set<String> combo;
    private final double discountAmount;

    public ApplyComboDiscount(Set<String> combo, double discountAmount) {
        this.combo = combo;
        this.discountAmount = discountAmount;
    }

    @Override
    public void apply(Order order) {
        boolean hasAll = true;
        for (String comboItem : combo) {
            boolean found = false;
            for (OrderItem orderItem : order.getItems()) {
                String orderName = orderItem.getProduct().getName().toLowerCase();
                String comboName = comboItem.toLowerCase();
                if (orderName.equals(comboName)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                hasAll = false;
                break;
            }
        }
        if (hasAll) {
            order.applyDiscount(discountAmount);
        }
    }
}


