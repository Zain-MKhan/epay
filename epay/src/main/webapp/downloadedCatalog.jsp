<%@ page contentType="text/csv; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="business.Product" %>
<%@ page import="dbObjects.ProductObject" %>
<%@ page import="java.io.*" %>
<%@ page import="connection.dbConnection" %>
<%
response.setHeader("Content-Disposition", "attachment; filename=product_catalog.csv");
response.setContentType("text/csv");
%>

<%
ProductObject pdobj = new ProductObject(dbConnection.getConnection());
List<Product> products = pdobj.getAllProducts();   
%>

SKU,Name,Description,Price,Vendor,Slug,Image
<%
for (Product product : products) {
    out.println(product.getSku() + "," + product.getName() + "," + product.getDescription() + ","
        + product.getPrice() + "," + product.getVendor() + "," + product.getSlug() + "," + product.getImage());
}
%>
