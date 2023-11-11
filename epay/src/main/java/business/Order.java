package business;

import java.util.ArrayList;
import java.util.List;

public class Order extends Cart {
    private int orderId;
    private String email;
    private int quantity;
    private String date;
    private int trackingNumber;
    private String status;
    

    private List<String> allProducts;
    private List<Order> order = new ArrayList<>();
    
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


    public Order(List<String> allProducts) {
        this.allProducts = allProducts;
    }

    public List<String> getOrder() {
        return allProducts;
    }

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


    public void createOrder(int user, String shippingAddress) {
        Cart userCart = getCartByUser(user);
        try{
        if (userCart != null) {

          Order order = new Order(user,shippingAddress);
          order.addProduct(userCart);
          clearCart(user);
        }else{

           throw new CustomNullCartExceptions();
        }}catch(CustomNullCartExceptions e){
        System.out.println(e.getMessage());
      }

    }

    public List<Order> getOrders(int user) {
      List<Order> userOrders = new ArrayList<>();
      for (Order order : order) {
          if (order.getUser(user)==(user)) {
              userOrders.add(order);
          }
      }
      return userOrders;
    }

    public Order getOrder(String user, int orderId) {

        try{
      for (Order order : order) {
        if (order.getOrderId() == orderId) {

          if(order.getUsername.equals(user)){
            order.toString();
            return order;
          }
          
        }else{
           throw new CustomUnmatchedIDException();
        }
     }

    }catch(CustomUnmatchedIDException e){
        System.out.println(e.getMessage());
      }
      return null;
    }

    public Order ShipOrder(int id, int trackingNumber) {
   
        try{
      for (Order order : order) {
          if (order.getOrderId() == id) {
            order.setStatus("Shipped");
            order.setTrackingNumber(trackingNumber);
            System.out.println("order id=" +order.getOrderId()+" Status=" + order.getStatus()+ "Tracking number will be: " + order.getTrackingNumber());
            return order;
          }  else{
           throw new CustomUnmatchedIDException();
        }
      }
   
    }catch(CustomUnmatchedIDException e){
        System.out.println(e.getMessage());
      }
      return null;
     }
  
}
