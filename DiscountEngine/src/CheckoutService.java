import models.Discount;
import models.Order;
import java.util.Set;

public class CheckoutService {

    Set<Discount> availableDiscounts;

    public CheckoutService (Set<Discount> discounts){
        this.availableDiscounts = discounts;
    }

    public void checkout(Order order){
        for(Discount discount : availableDiscounts) {
            discount.apply(order);
        }
    }
}
