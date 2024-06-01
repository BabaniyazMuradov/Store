package Data.Models;

import java.util.ArrayList;

public class Order {
    public final String name;
    public final String phone;
    public final String address;
    public final String paymentType;
    public final String deliveryType;
    public final ArrayList<CartItem> cart;

    public Order(String name, String phone, String address, String paymentType, String deliveryType, ArrayList<CartItem> cart) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
        this.cart = cart;
    }
}
