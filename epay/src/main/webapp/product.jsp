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
%>

<%
String slug = (String) session.getAttribute("slug");
%>
<!doctype html>
<html lang="en">
  <head>
    <title>Epay</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>

    <%
      if(!products.isEmpty()){
        for (Product p: products){
          if(p.getSlug().equals(slug)){%>
            <div class="card" style="width: 50%;">
              <img src=<%=p.getImage()%> class="card-img-top" alt="img" style="width: 50%; height: auto;">
              <div class="card-body">
                <h4 class="card-title"><%=p.getName() %></h4>
                <h5 class="card-text"><%=p.getVendor()%></h5>
                <p class="card-text"><%=p.getDescription() %></p>

                <% if (authorizedStaff != null) { %>
                  <div class="card" style="width: 50%;">
                      <img src=<%= p.getImage() %> class="card-img-top" alt="img" style="width: 50%; height: auto;">
                      <div class="card-body">
                          <h4 class="card-title"><%= p.getName() %></h4>
                          <h5 class="card-text"><%= p.getVendor() %></h5>
                          <p class="card-text"><%= p.getDescription() %></p>
                          
                          <form action="products/<%=p.getSlug()%>" method="post">
                              <div class="form-group">
                                  <label for="name">Name:</label>
                                  <input type="text" class="form-control" id="name" name="name" value="<%= p.getName() %>">
                              </div>
                              <div class="form-group">
                                  <label for="price">Price:</label>
                                  <input type="number" class="form-control" id="price" name="price" value="<%= p.getPrice() %>" step="0.01">
                              </div>
                              <div class="form-group">
                                  <label for="description">Description:</label>
                                  <textarea class="form-control" id="description" name="description"><%= p.getDescription() %></textarea>
                              </div>
                              <div class="form-group">
                                  <label for="vendor">Vendor:</label>
                                  <input type="text" class="form-control" id="vendor" name="vendor" value="<%= p.getVendor() %>">
                              </div>
                              <div class="form-group">
                                  <label for="image">Image URL:</label>
                                  <input type="text" class="form-control" id="image" name="image" value="<%= p.getImage() %>">
                              </div>
                              <input type="hidden" name="slug" value="<%= p.getSlug() %>">
                              <button type="submit" class="btn btn-primary">Update Product</button>
                          </form>
                      </div>
                  </div>
              <% } %>
              
              </div>
            </div>
          <%break;
          }
        }
      }
    %>
    <% out.print(dbConnection.getConnection());%>
    <%@include file="layout/footer.jsp"%>
  </body>
</html>