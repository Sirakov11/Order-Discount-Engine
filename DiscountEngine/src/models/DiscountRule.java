package models;

public interface DiscountRule {
    void apply(Order order);
}
