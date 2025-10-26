package models;
import models.Order;

public interface DiscountRule {
    void apply(Order order);
}
