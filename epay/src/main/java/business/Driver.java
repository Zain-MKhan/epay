package business;

public class Driver {
    public static void main(String[] args) {


        //some raw testing in driver...
        int sku = 4;
        String name = "laptop";

        int sku2 = 12;
        String name2 = "pc";
        System.out.println("testing creation of product");    
        Product p = new Product(sku,name);
        Product p2 = new Product(sku2,name2);
        Product p3 = new Product(sku,name);
        p3.CreateProduct(sku,name);
        System.out.println(p3);        

        
        System.out.println("testing update of product");    
        p.UpdateProduct(sku, name,12.02,"Wow new laptop","asus","x-00203l","");
        p2.UpdateProduct(sku, name,11112.02,"Wow new pc","apple","i12xxx","");
        System.out.println(p);    
        
        System.out.println("testing getting product by sku");    
        p.getProduct(sku);
        System.out.println(p);  
        p2.getProduct(12);
        System.out.println(p2);  

        System.out.println("testing getting product by slug");   
        p2.getProductWithSlug("i12xxx");
        System.out.println(p2);  

        //ect



        
    }
}
