package models;
import java.util.List;

public class Order {
    private final int id;
    private final List<OrderItem> items;
    private double total;
    private double discountApplied;

    public Order(int id, List<OrderItem> items, double total, double discountApplied){
        this.id = id;
        this.items = items;
        this.total = total;
        this.discountApplied = discountApplied;
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
}
