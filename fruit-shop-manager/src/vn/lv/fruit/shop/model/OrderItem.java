package vn.lv.fruit.shop.model;

import vn.lv.fruit.shop.utils.AppUtils;
import vn.lv.fruit.shop.utils.InstantUtils;

import java.time.Instant;

public class OrderItem {
    private long id;
    private double price;
    private double quantity;
    private long orderId;
    private long productId;
    private String productName;
    private double total;
    private Instant creatAt;

    public OrderItem(long id, double price, double quantity, long orderId, long productId, String productName, double total, Instant creatAt) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.total = total;
        this.creatAt = creatAt;
    }

    public OrderItem() {
    }

    public static OrderItem parseOrderItem(String record) {
        String[] fields = record.split(",");
        long id = Long.parseLong(fields[0]);
        double price = Double.parseDouble(fields[1]);
        double quantity = Double.parseDouble(fields[2]);
        long orderId = Long.parseLong(fields[3]);
        long productId = Long.parseLong(fields[4]);
        String productName = fields[5];
        double total = Double.parseDouble(fields[6]);
        Instant creatAt = Instant.parse((fields[7]));

        return new OrderItem(id, price, quantity, orderId, productId, productName, total, creatAt);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Instant getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Instant creatAt) {
        this.creatAt = creatAt;
    }

    @Override
    public String toString() {
        return id + "," + price + "," + quantity + "," + orderId + "," + productId + "," + productName + "," + total + "," + creatAt;
    }


}
