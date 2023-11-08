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

<!doctype html>
<html lang="en">
  <head>
    <title>Download Product Catalog</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>

    <% if (authorizedStaff != null) { %>
        <div class="card" style="width: 50%;">
            <div class="card-body">
                <h4 class="card-title">Product Catalog</h4>
                <p>Download the product catalog as a CSV file:</p>
                <a href="downloadedCatalog.jsp" class="btn btn-primary">Download Catalog</a>
            </div>
        </div>
    <% } %>
    <% out.print(dbConnection.getConnection());%>
    <%@include file="layout/footer.jsp"%>
  </body>
</html>