package business;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Product {

	private int quantity;
	private String shippingAddress;
	public long userId;
	private List<Product> allProducts = new ArrayList<>();
	private List<Cart> cart = new ArrayList<>();

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


	public List<Product> getCart(int user) {
		Cart userCart = getCartByUser(user);
		return userCart.getAllProducts();
	  }
  
	  public Cart getCartByUser(int user) {
		for (Cart c : cart) {
			if (c.getUserId(user)== user) {
				return c;
			}
		}
		return null;
	  }
  
	  public void addProductToCart(int user, int sku) {


		try{
		Product p = (Product) getProductWithSku(sku);
		if (p != null) {
			Cart userCart = (Cart) getCart(user);
			userCart.addProduct(p);
		} else{
				throw new CustomNullProductExceptions();
		}
	}catch(CustomNullProductExceptions e){
		System.out.println(e.getMessage());
	}
	   }
	   
  
	  public void removeProductFromCart(int user, int sku) {
		try{
	  Cart userCart = getCartByUser(user);
	  if (userCart != null) {
		  userCart.removeProduct(sku);
		
	  }
	  else{
		  throw new CustomNullCartExceptions();
	  }  	
	}catch(CustomNullCartExceptions e){
		System.out.println(e.getMessage());
	}
	  }
  
	  public void setProductQuantityInCart(int user, int sku, int quantity) {
			Cart userCart = (Cart) getCart(user);
			userCart.setQuantity(quantity);
		}
  
	   public void clearCart(int user) {

		try{
			Cart c = getCartByUser(user);
			if (c != null) {
				cart.remove(c);
			
			}
			else{
					throw new CustomNullCartExceptions();
			}
		}catch(CustomNullCartExceptions e){
		System.out.println(e.getMessage());
	}
		}	

}
