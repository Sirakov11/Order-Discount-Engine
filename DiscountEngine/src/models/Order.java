package models;
import java.util.List;

public class Order {
    private final int id;
    private final List<OrderItem> items;
    private double total;
    private double discountApplied;

    public Order(int id, List<OrderItem> items){
        this.id = id;
        this.items = items;
        this.total = calculateTotal();
        this.discountApplied = 0;
    }

    private double calculateTotal(){
        double total = 0;
        for (OrderItem item: items){
            total += item.getTotalPrice();
        }
        return total;
    }
    public int getId(){
        return id;
    }
    public List<OrderItem> getItems(){
        return items;
    }
    public double getTotal(){
        return total;
    }
    public double getDiscountApplied(){
        return discountApplied;
    }

    public void applyDiscount(double discount){
        this.discountApplied += discount;
        this.total -= discount;
    }
}
