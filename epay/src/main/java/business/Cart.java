package business;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Product {

	private int quantity;
	private String shippingAddress;
	public long userId;
	private List<Product> allProducts = new ArrayList<>();

	public Cart() {
	}

	public Cart(long userId) {
        this.userId = userId;
        this.allProducts = new ArrayList<>();
    }

	public List<Product> getAllProducts() {
        return allProducts;
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getUserId(long userId) {
		this.userId = userId;
		return (int) userId;
	}

	public void addProduct(Product product) {
        allProducts.add(product);
    }

    public void removeProduct(int sku) {
		allProducts.remove(sku);
    }


	


}
