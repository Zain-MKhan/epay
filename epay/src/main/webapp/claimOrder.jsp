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

<!doctype html>
<html lang="en">
  <head>
    <title>Epay</title>
    <%@include file="layout/header.jsp"%>
    <link href="index.css" rel="stylesheet" type="text/css"/>

  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>

    <div class="card" style="width: 50%;">
        <div class="card-body">
            <h4 class="card-title">Claim a guest-created order</h4>
            
            <form action="claimOrder" method="post">
                <div class="form-group">
                    <label for="orderid">Please enter the order id: </label>
                    <input type="text" class="form-control" id="orderid" name="orderid">
                </div>
                <button type="submit" class="btn btn-primary">Claim Order</button>
            </form>
        </div>
    </div>
    
    <%@include file="layout/footer.jsp"%>
  </body>
</html>