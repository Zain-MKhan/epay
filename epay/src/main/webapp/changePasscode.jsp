<%@page import="business.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="connection.dbConnection" %>
<%@page import="dbObjects.ProductObject" %>
<%@ page isELIgnored="false" %>
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
    <title>Change passcode</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
	<%@include file="layout/navbar.jsp"%>
    <div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Change passscode</div>
			<div class="card-body">
				<form action="change" method="post">
					<div class="form-group">
						<label>Email address</label> 
						<input type="text" id = "email" name="email" class="form-control" placeholder="Email" value="user@gmail.com" required>
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="text" id = "password" name="password" class="form-control" placeholder="Password" value="secret" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Confirm</button>
					</div>
				</form>
			</div>
		</div>
	</div>
    <%@include file="layout/footer.jsp"%>
  </body>
</html>