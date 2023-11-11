package business;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private List<Product> products = new ArrayList<>();
	private int sku;
	private String name;
	private Double price;
	private String description;
	private String vendor;
	private String slug;
	private String image;

	public Product() {
	}

	public Product(int sku, String name) {

		super();
		this.sku = sku;
		this.name = name;

	}

	public Product(int sku, String name, Double price, String description, String vendor, String slug, String image) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.image = image;
		this.description = description;
		this.vendor = vendor;
		this.slug = slug;

	}

	public Product(int sku, String name, Double price, String vendor, String slug) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.vendor = vendor;
		this.slug = slug;

	}

	public void UpdateProduct(int sku, String name, Double price, String description, String vendor, String slug,
			String image) {
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.description = description;
		this.vendor = vendor;
		this.slug = slug;
		this.image = image;
	}

	public String getProduct(int sku) {

		List<Product> products = new ArrayList<>();
		for (Product product : products) {
			if (product.getSku() == sku) {
				return product.toString();
			}
		}
		return null;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	@Override
	public String toString() {
		return "Product [sku=" + sku + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", vendor=" + vendor + ",  image="
				+ image + "]";
	}

}
