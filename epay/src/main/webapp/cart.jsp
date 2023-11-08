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
    ArrayList<Cart> cl = (ArrayList<Cart>) session.getAttribute("somelist");
      List<Cart> cartProduct = null;
      if (cl != null) {
        ProductObject pdobj = new ProductObject(dbConnection.getConnection());
        cartProduct = pdobj.getCartProducts(cl);
        request.setAttribute("somelist", cl);
      }    
    
    
%>

<!doctype html>
<html lang="en">
  <head>
    <title>Cart</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>

    <div class="container">
      <div class=" d-flex py-3"><h3>Total price</h3><a class="mx-3 btn btn-primary" href="#">Confirm</a></div>

      <table class="table table-light">
        <thead>
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Vendor</th>
            <th scope="col">Price</th>
            <th scope="col">TBD</th>
            <th scope="col">Cancel</th>
          </tr>
        </thead>

        <tbody>
          <tr><td>gege</td></tr>
          <%
            if (!products.isEmpty()) {
              for (Cart c: cartProduct) {%>

                <tr>
                  <td><%=c.getName()%></td>
                  <td><%=c.getDescription()%></td>
                  <td><%=c.getVendor()%></td>
                  <td><%=c.getPrice()%></td>
                  <td>
      
                    <form action="" method="post" class="form-inline">
                    <input type="hidden" name="sku" value="<%= c.getSku()%>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
      
                      <a class="btn btn-sm btn-incre" href="#"><i class="fas fa-plus-square"></i></a>
                      <input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly>
                      <a class="btn btn-sm btn-incre" href="#"><i class="fas fa-minus-square"></i></a>
                    </div>
                    </form>
                  </td>
                  <td><a href="#" class="btn btn-sm btn-danger">Remove</a></td>
                </tr>
				
          <%}
      }

      else {
        out.println("none");
        }
    %>
        </tbody>

      </table>

    
      
    </div>
    
    <%@include file="layout/footer.jsp"%>
  </body>
</html>