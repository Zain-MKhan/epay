<%@page import="business.*" %>
<%@page import="java.util.ArrayList" %>
<% Customer authorizedCustomer = (Customer) request.getSession().getAttribute("authorizedCustomer"); 
    if (authorizedCustomer!=null){
		response.sendRedirect("index.jsp");
    } 
%>
<% Staff authorizedStaff = (Staff) request.getSession().getAttribute("authorizedStaff"); 
    if (authorizedStaff!=null){
        request.setAttribute("authorizedStaff", authorizedStaff);
    } 

ArrayList<Cart> somelist = (ArrayList<Cart>) session.getAttribute("somelist");
	if (somelist != null) {
		request.setAttribute("somelist", somelist);
	}  	
%>

<!doctype html>
<html lang="en">
  <head>
    <title>Customer Login</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
	<%@include file="layout/navbar.jsp"%>
    <div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Customer Login</div>
			<div class="card-body">
				<form action="customer-login" method="post">
					<div class="form-group">
						<label>Email address</label> 
						<input type="email" name="login-email" class="form-control" placeholder="Email" value="user@gmail.com" required>
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="login-password" class="form-control" placeholder="Password" value="secret" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
    <%@include file="layout/footer.jsp"%>
  </body>
</html>