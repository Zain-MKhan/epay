<%@page import="connection.dbConnection" %>
<%@page import="dbObjects.ProductObject" %>

<%@page import="business.*" %>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Customer authorizedCustomer = (Customer) request.getSession().getAttribute("authorizedCustomer"); 
    if (authorizedCustomer!=null){
        request.setAttribute("authorizedCustomer", authorizedCustomer);
    } 
%>
<% Staff authorizedStaff = (Staff) request.getSession().getAttribute("authorizedStaff"); 
    if (authorizedStaff!=null){
        request.setAttribute("authorizedStaff", authorizedStaff);
    } 
%>

<%
ProductObject pdobj = new ProductObject(dbConnection.getConnection());
List<Product> products = pdobj.getAllProducts(); 
    
ArrayList<Cart> somelist = (ArrayList<Cart>) session.getAttribute("somelist");
    if (somelist != null) {
        request.setAttribute("somelist", somelist);
    }      
%>

<!doctype html>
    <html lang="en">
      <head>
        <title>Staff Login</title>
        <%@include file="layout/header.jsp"%>
      </head>
      <body>
        <%@include file="layout/navbar.jsp"%>
        <% if (authorizedStaff != null) { %>
            <div class="card" style="width: 50%;">
                <div class="card-body">
                    <h4 class="card-title">Create new product</h4>
                    
                    <form action="products/create" method="post">
                        <div class="form-group">
                            <label for="sku">SKU:</label>
                            <input type="text" class="form-control" id="sku" name="sku">
                        </div>
                        <div class="form-group">
                            <label for="sku">Slug:</label>
                            <input type="text" class="form-control" id="slug" name="sku">
                        </div>
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                        <div class="form-group">
                            <label for="price">Price:</label>
                            <input type="number" class="form-control" id="price" name="price" step="0.01">
                        </div>
                        <div class="form-group">
                            <label for="description">Description:</label>
                            <textarea class="form-control" id="description" name="description"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="vendor">Vendor:</label>
                            <input type="text" class="form-control" id="vendor" name="vendor">
                        </div>
                        <div class="form-group">
                            <label for="image">Image URL:</label>
                            <input type="text" class="form-control" id="image" name="image">
                        </div>
                        <input type="hidden" name="slug" value="new-product-slug">
                        <button type="submit" class="btn btn-primary">Create Product</button>
                    </form>
                </div>
            </div>
        <% } %>
        <%@include file="layout/footer.jsp"%>
    </body>
    </html>