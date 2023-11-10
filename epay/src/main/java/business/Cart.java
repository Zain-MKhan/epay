package business;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Product{

    private int quantity;
	private List<String> allProducts = new ArrayList<>();

	public Cart() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
