import models.Discount;
import models.Order;

public class OrderByValue implements Discount {

    @Override
    public void apply(Order order) {
            if (order.getTotal() > 100){
                double discount = order.getTotal() *0.10;
                order.applyDiscount(discount);
            }
    }
}
