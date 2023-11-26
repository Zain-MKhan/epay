package servlets;

import java.io.IOException;

import business.Product;
import connection.dbConnection;
import dbObjects.ProductObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@jakarta.servlet.annotation.WebServlet("/products/*")
public class productsSlugServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the user is already on "cart.jsp"
        // Get the slug from the request URL
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            // Remove the leading slash and split the path into parts
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length > 1) {
                String slug = pathParts[1]; // The slug is the second part
                request.getSession().setAttribute("slug", slug);
            }
        }
        // Redirect to "product.jsp"
        response.sendRedirect(request.getContextPath() + "/product.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Retrieve form data
        String skuStr = request.getParameter("sku");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String vendor = request.getParameter("vendor");
        String slug = request.getParameter("slug");
        String priceStr = request.getParameter("price");
        String image = request.getParameter("image");

        try {
            // Parse Price from string to double
            double price = Double.parseDouble(priceStr);
            int sku = -1;
            if (skuStr != null && !skuStr.isEmpty()) {
                sku = Integer.parseInt(skuStr);
            }

            // Create or modify the product
            ProductObject pdobj = new ProductObject(dbConnection.getConnection());
            Product product = pdobj.getProductBySlug(slug);

            if (product == null) {
                // Product doesn't exist, create a new one
                product = new Product();
                product.setSku(sku);
                product.setName(name);
                product.setDescription(description);
                product.setVendor(vendor);
                product.setSlug(slug);
                product.setPrice(price);
                product.setImage(image);
                pdobj.insertProduct(product);
                System.out.println("Successfully created product!");
            } else {
                // Product exists, update its details
                product.setName(name);
                product.setDescription(description);
                product.setVendor(vendor);
                product.setPrice(price);
                product.setImage(image);
                pdobj.updateProduct(product);
                System.out.println("Successfully updated product!");
            }

            // Redirect to a confirmation page or another appropriate page
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (NumberFormatException e) {
            // Handle the case where Price cannot be parsed as a number
            e.printStackTrace(); // Log the exception for debugging
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            System.out.println("Failed to update product due to a number format error.");
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace(); // Log the exception for debugging
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            System.out.println("Failed to update product for other reasons.");
        }
    }

}
