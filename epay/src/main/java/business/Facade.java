package business;

import java.util.ArrayList;
import java.util.List;

public class Facade {


    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList();


    public Product CreateProduct(int sku, String name){

		Product p = new Product(sku,name);
		return p;

	}

    
}
