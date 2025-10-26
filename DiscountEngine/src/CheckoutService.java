import models.Order;
import java.util.Set;

public class CheckoutService {

    public void checkout(Order order){
        DiscountEngine.applyOrderValueDiscount(order);
        DiscountEngine.applyBuyXGetYFree(order, "Tea", 3, 1);
        DiscountEngine.applyComboDiscount(order, Set.of("Coffee", "Milk"), 5);
    }
}
