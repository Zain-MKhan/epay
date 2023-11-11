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

  public Product CreateProduct(int sku, String name) {

    Product p = new Product(sku, name);
    products.add(p);
    return p;
  }

  public void updateProduct(int sku, String name, Double price, String description, String vendor, String slug,
      String image) {
    try {
      Product productToUpdate = (Product) getProductWithSku(sku);
      if (productToUpdate != null) {
        productToUpdate.UpdateProduct(sku, name, price, description, vendor, slug, image);

        throw new CustomNullProductExceptions();
      }
    } catch (CustomNullProductExceptions e) {
      System.out.println(e.getMessage());
    }
  }

  public Object getProductWithSku(int sku) {

    try {
      List<Product> products = new ArrayList<>();
      for (Product product : products) {
        if (product.getSku() == sku) {
          return product.getSku();
        } else {
          throw new CustomUnmatchedIDException();
        }
      }
    } catch (CustomUnmatchedIDException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public Object getProductWithSlug(String slug) {

    List<Product> products = new ArrayList<>();
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
      if (c.getUserId(user) == user) {
        return c;
      }
    }
    return null;
  }

  public void addProductToCart(int user, int sku) {

    try {
      Product p = (Product) getProductWithSku(sku);
      if (p != null) {
        Cart userCart = (Cart) getCart(user);
        userCart.addProduct(p);
      } else {
        throw new CustomNullProductExceptions();
      }
    } catch (CustomNullProductExceptions e) {
      System.out.println(e.getMessage());
    }
  }

  public void removeProductFromCart(int user, int sku) {
    try {
      Cart userCart = getCartByUser(user);
      if (userCart != null) {
        userCart.removeProduct(sku);

      } else {
        throw new CustomNullCartExceptions();
      }
    } catch (CustomNullCartExceptions e) {
      System.out.println(e.getMessage());
    }
  }

  public void setProductQuantityInCart(int user, int sku, int quantity) {
    Cart userCart = (Cart) getCart(user);
    userCart.setQuantity(quantity);
  }

  public void clearCart(int user) {
    try {
      Cart c = getCartByUser(user);
      if (c != null) {
        cart.remove(c);

      } else {
        throw new CustomNullCartExceptions();
      }
    } catch (CustomNullCartExceptions e) {
      System.out.println(e.getMessage());
    }
  }

  public void createOrder(int user, String shippingAddress) {
    Cart userCart = getCartByUser(user);
    try {
      if (userCart != null) {

        Order order = new Order(user, shippingAddress);
        order.addProduct(userCart);
        clearCart(user);
      } else {

        throw new CustomNullCartExceptions();
      }
    } catch (CustomNullCartExceptions e) {
      System.out.println(e.getMessage());
    }

  }

  public List<Order> getOrders(int user) {
    List<Order> userOrders = new ArrayList<>();
    for (Order order : order) {
      if (order.getUser(user) == (user)) {
        userOrders.add(order);
      }
    }
    return userOrders;
  }

  public Order getOrder(String user, int orderId) {

    try {
      for (Order order : order) {
        if (order.getOrderId() == orderId) {

          if (order.getUsername.equals(user)) {
            order.toString();
            return order;
          }

        } else {
          throw new CustomUnmatchedIDException();
        }
      }

    } catch (CustomUnmatchedIDException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public Order ShipOrder(int id, int trackingNumber) {

    try {
      for (Order order : order) {
        if (order.getOrderId() == id) {
          order.setStatus("Shipped");
          order.setTrackingNumber(trackingNumber);
          System.out.println("order id=" + order.getOrderId() + " Status=" + order.getStatus()
              + "Tracking number will be: " + order.getTrackingNumber());
          return order;
        } else {
          throw new CustomUnmatchedIDException();
        }
      }

    } catch (CustomUnmatchedIDException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

}
