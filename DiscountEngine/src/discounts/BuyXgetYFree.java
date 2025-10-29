package discounts;

import models.Discount;
import models.Order;
import models.OrderItem;

public class BuyXgetYFree implements Discount {
    private final int free;
    private final String productName;
    private int buy;

    public BuyXgetYFree(String productName, int buy, int free) {
        this.productName = productName;
        this.buy = buy;
        this.free = free;
    }

    @Override
    public void apply(Order order){
        for (OrderItem item : order.getItems()){
            if (item.getProduct().getName().equals(productName)){
                int groupSize = buy + free;
                int freeItems = (item.getQuantity() / groupSize) * free;
                double discount = freeItems * item.getProduct().getPrice();
                order.applyDiscount(discount);
            }
        }

    }
}


