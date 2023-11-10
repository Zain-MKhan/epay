package business;

import java.util.ArrayList;
import java.util.List;

public class Facade {


    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<User> user = new ArrayList<>();
    private List<Cart> cart = new ArrayList<>();
    private List<Order> order = new ArrayList<>();


    public Facade() {

    }

    public Product CreateProduct(int sku, String name){

		Product p = new Product(sku, name);
    products.add(p);
    return p;
    }



    public void updateProduct(int sku, String name, Double price, String description, String vendor, String slug, String image) {
      Product productToUpdate = (Product) getProductWithSku(sku);
      if (productToUpdate != null) {
          productToUpdate.UpdateProduct(sku, name, price, description, vendor, slug, image);
      } else {

        //can prob error handle here
          System.out.println("prd dne ske dne.");
        }
      }

  
    public Object getProductWithSku(int sku) {

      List<Product> products = new  ArrayList<>();
      for (Product product : products) {
        if (product.getSku() == sku) {
          return product.getSku();
        }
      }
      return null;
    }

    public Object getProductWithSlug(String slug) {

      List<Product> products = new  ArrayList<>();
      for (Product product : products) {
        if (product.getSlug().equals(slug)) {
          return product.getSlug();
        }
      }
      return null;
    }


    public List<Product> getCart(int user) {
      Cart userCart = getCartByUser(user);
      return userCart.getAllProducts();
    }

    private Cart getCartByUser(int user) {
      for (Cart c : cart) {
          if (c.getUserId(user)== user) {
              return c;
          }
      }
      return null;
    }

    public void addProductToCart(int user, int sku) {
      Product p = (Product) getProductWithSku(sku);
      if (p != null) {
          Cart userCart = (Cart) getCart(user);
          userCart.addProduct(p);
      } else {
      //can prob error handle here

            System.out.println("prd not added function.");
      }
     }

    public void removeProductFromCart(int user, int sku) {
    Cart userCart = getCartByUser(user);
    if (userCart != null) {
        userCart.removeProduct(sku);
    }else{
       //can prob error handle here
       System.out.println("nothing will be perfomed. for car removval.");
      }
    }

    public void setProductQuantityInCart(int user, int sku, int quantity) {
          Cart userCart = (Cart) getCart(user);
          userCart.setQuantity(quantity);
      }

     public void clearCart(int user) {
          Cart c = getCartByUser(user);
          if (c != null) {
              cart.remove(c);
          }
      }

    public void createOrder(int user, String shippingAddress) {
        Cart userCart = getCartByUser(user);
        if (userCart != null) {

          Order order = new Order(user,shippingAddress);
          order.addProduct(userCart);
          clearCart(user);
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
      for (Order order : order) {
        if (order.getOrderId() == orderId) {

          if(order.getUsername.equals(user)){
            order.toString();
            return order;
          }
          
        }else{
              //can prob error handle here
       System.out.println("nothing will be perfomed. for car removval.");
       return null;
        }

      }
      return null;
    }

    public Order ShipOrder(int id, int trackingNumber) {
   
      for (Order order : order) {
          if (order.getOrderId() == id) {
            order.setStatus("Shipped");
            order.setTrackingNumber(trackingNumber);
            System.out.println("order id=" +order.getOrderId()+" Status=" + order.getStatus()+ "Tracking number will be: " + order.getTrackingNumber());
            return order;
          }
      }
      System.out.println("it wasnt found sadge");
      return null;
     }
  









    
}
