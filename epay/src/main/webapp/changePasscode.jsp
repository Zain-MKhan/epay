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
						<%if (authorizedCustomer!=null){ %>
							<label>Email address: <%=authorizedCustomer.getEmail()%></label> 
							<input type="hidden" name="email" value="<%=authorizedCustomer.getEmail()%>" class="form-input">
						<%} else if (authorizedStaff!=null){ %>
							<label>Email address: <%=authorizedStaff.getUserName()%></label> 
							<input type="hidden" name="email" value="<%=authorizedStaff.getUserName()%>" class="form-input">
						<%}%>		
					</div>
					<div class="form-group">
						<label>Password</label> 
						<%if (authorizedCustomer!=null){ %>
							<input type="text" id = "password" name="password" class="form-control" placeholder="Password" value="<%=authorizedCustomer.getPassword()%>" required>
						<%} else if (authorizedStaff!=null){ %>
							<input type="text" id = "password" name="password" class="form-control" placeholder="Password" value="<%=authorizedStaff.getPassword()%>" required>
						<%}%>
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