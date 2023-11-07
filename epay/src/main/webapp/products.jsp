<%@page import="connection.dbConnection" %>
<%@page import="business.*" %>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Customer authorizedCustomer = (Customer) request.getSession().getAttribute("authorizedCustomer"); 
    if (authorizedCustomer!=null){
        request.setAttribute("authorizedCustomer", authorizedCustomer);
    } %>

<!doctype html>
<html lang="en">
  <head>
    <title>Epay</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>


<div class = "container">
      <h1>Products</h1>
<div class="row">
  <div class=" col-md-3">
    <div class="card w-100" style="width: 18rem;">
      <img class="card-img-top" src="prdimages/shop1.png" alt="img">
      <div class="card-body">
        <h5 class="card-title">Product name</h5>
        <h6 class="price">123$</h6>
        <p class="description-text">here will lie the description-text of the product.</p>
        <div class=" mt-3 d-flex justify-content-between">
          <a href="cart.jsp" class="btn btn-primary">Add to cart</a>
          <a href="#" class="btn btn-primary">View product</a>
        </div>
      </div>
    </div>
  </div>
</div>

    </div>

    <p>delete below after.</p>
    <% out.print(dbConnection.getConnection());%>

    <%@include file="layout/footer.jsp"%>
  </body>
</html>