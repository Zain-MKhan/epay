package business;

import java.util.List;

public class Order extends Cart {
    private int orderId;
    private String email;
    private int quantity;
    private String date;
    private int trackingNumber;
    private String status;
    // private String shippingAddress;

    private List<String> allProducts;
    public Object getUsername;

    public Order() {
    }

    public Order(int user,String shippingAddress) {

    }

    public Order(int orderId, String email, int quantity, String date) {
        super();
        this.orderId = orderId;
        this.email = email;
        this.quantity = quantity;
        this.date = date;
    }

    // public Order(List<String> allProducts, String shippingAddress) {
    // this.allProducts = allProducts;
    // this.shippingAddress = shippingAddress;
    // }
    public Order(List<String> allProducts) {
        this.allProducts = allProducts;
    }

    public List<String> getOrder() {
        return allProducts;
    }

    // public String getShippingAddress() {
    // return shippingAddress;
    // }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int qunatity) {
        this.quantity = qunatity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public int getUser(int user) {
        return user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
