package vn.lv.fruit.shop.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private Long id;
    private String fullName;
    private String phone;
    private String address;
    private Double grandTotal;
    private Instant createdAt;
    List<OrderItem> orderItems = new ArrayList<>();

    public Order() {    }

    public Order(long id, String fullName, String phone, String address) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }

    public static Order parse(String record) {
        Order order = new Order();
        String[] field = record.split(",");
        order.id = Long.parseLong(field[0]);
        order.fullName = field[1];
        order.phone = field[2];
        order.address = field[3];
        return order;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return address;
    }

    public void setEmail(String address) {
        this.address = address;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return id + "," + fullName + "," + phone + "," + address;
    }
}

