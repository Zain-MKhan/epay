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
        <h1>There was an error processing your request.</h1>
    <%@include file="layout/footer.jsp"%>
  </body>
</html>