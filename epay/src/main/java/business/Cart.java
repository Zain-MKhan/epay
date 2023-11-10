package business;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Product {

	private int quantity;
	private String shippingAddress;
	private List<String> allProducts = new ArrayList<>();

	public Cart() {
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
}
