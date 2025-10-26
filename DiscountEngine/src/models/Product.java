package models;

public class Product {
    private final int id;
    private final String name;
    private final double price;
    private final String currency;
    public Product(int id, String name, double price, String currency){
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getCurrency(){
        return currency;
    }
}
