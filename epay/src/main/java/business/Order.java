package business;

import java.util.List;

public class Order {
    
    private List<String> allProducts;
    private String shippingAddress;

    public Order(List<String> allProducts, String shippingAddress) {
        this.allProducts = allProducts;
        this.shippingAddress = shippingAddress;
    }

    public List<String> getOrder() {
        return allProducts;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
