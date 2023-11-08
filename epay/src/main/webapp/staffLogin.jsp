<%@page import="business.*" %>
<% Customer authorizedCustomer = (Customer) request.getSession().getAttribute("authorizedCustomer"); 
    if (authorizedCustomer!=null){
		response.sendRedirect("index.jsp");
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
        <title>Staff Login</title>
        <%@include file="layout/header.jsp"%>
      </head>
      <body>
        <%@include file="layout/navbar.jsp"%>
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">Staff Login</div>
                <div class="card-body">
                    <form action="staff-login" method="post">
                        <div class="form-group">
                            <label>User Name</label> 
                            <input type="text" name="login-staff-user" class="form-control" placeholder="hint:staff" value="staff" required>
                        </div>
                        <div class="form-group">
                            <label>Password</label> 
                            <input type="password" name="login-staff-password" class="form-control" placeholder="hint:secret" value="secret" required>
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