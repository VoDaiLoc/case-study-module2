package vn.lv.fruit.shop.model;

import java.time.Instant;

public class Product {
    private long id;
    private String title;
    private double price;
    private double quantity;

    private Instant createdAt;

    private Instant updatedAt;

    public Product(){
    }

    public Product(long id, String title, double price, double quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(long id, String title, double price, double quantity, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Product parse(String record) {
        String[] fields = record.split(",");
        long id = Long.parseLong(fields[0]);
        String title = fields[1];
        double price = Double.parseDouble(fields[2]);
        double quantity = Double.parseDouble(fields[3]);
        Instant createdAt = Instant.parse(fields[4]);
        String temp = fields[5];
        Instant updatedAt = null;
        if (temp != null && !temp.equals("null"))
            updatedAt = Instant.parse(temp);
        return new Product(id, title, price, quantity, createdAt, updatedAt);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                id,
                title,
                price,
                quantity,
                createdAt,
                updatedAt);
    }
}
