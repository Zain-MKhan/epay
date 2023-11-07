package business;

public class Product {

    private int sku;
	private String name;
	private Double price;
    private String description;
    private String vendor;
    private String slug;
	private String image;


    public Product() {
	}
	
	public Product(int sku, String name, Double price,String description,String vendor,String slug, String image) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.image = image;
        this.description= description;
        this.vendor=vendor;
        this.slug= slug;

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



    @Override
	public String toString() {
		return "Product [sku=" + sku + ", name=" + name + ", price=" + price + ", image="
				+ image + "]";
	}
    
}
