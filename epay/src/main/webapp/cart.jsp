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


<%    
    ArrayList<Cart> cl = (ArrayList<Cart>) session.getAttribute("somelist");
      List<Cart> cartProduct = null;
      if (cl != null) {
        ProductObject pdobj = new ProductObject(dbConnection.getConnection());
        cartProduct = pdobj.getCartProducts(cl);
        double total = pdobj.getTotal(cl);
        request.setAttribute("somelist", cl); 
        request.setAttribute("total", total); 
      }    
    
%>



<!doctype html>
<html lang="en">
  <head>
    <title>Orders</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>
    <div class="container">
        <div class=" d-flex py-3"><h3>Welcome to the Cart Page</h3></div>
        <div class="card">
          <div class="card-body d-flex justify-content-between">
              <h3 class="card-title">Total Price</h3>
              <h3 class="card-text"><%=request.getAttribute("total")  %></h3>
              <a href="#" class="btn btn-primary">Checkout</a>
          </div>
      </div>

        <table class="table table-light">
            <thead>
              <tr>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Vendor</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Remove from Cart</th>
                <%if(authorizedCustomer != null){ %>
                <th scope="col">Shipping Address</th>
                <th scope="col">Order</th>
                <%}%>
                <%if(authorizedCustomer == null){ %>
                  <th scope="col">Login to place order!</th>
                <%}%>
              </tr>
            </thead>
            <tbody>
                <%
                if(cl!=null){
                    for(Cart c: cartProduct){%>
                        <tr>
                            <td><%=c.getName()%></td>
                            <td><%=c.getDescription()%></td>
                            <td><%=c.getVendor()%></td>
                            <td><%=c.getPrice()%></td>
                            <td>
              
                                <form action="" method="post" class="form-inline">
                                <input type="hidden" name="slug" value="<%=c.getSlug()%>" class="form-input">
                                <div class="form-group d-flex justify-content-between">
                  
                                  <a class="btn btn-sm btn-incre" href="cartq? act= inc& sku=<%=c.getSku()%>"><i class="fas fa-plus-square"></i></a>
                                  <input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly>
                                  <a class="btn btn-sm btn-incre" href="cartq?act=dec&sku= <%=c.getSku()%>"><i class="fas fa-minus-square"></i></a>
                                </div>
                                </form>
                              </td>

                              <td>
                                <a class="mx-3 btn btn-primary" href="cartdel?slug=<%=c.getSlug()%>">Remove</a>
                              </td>
                              <%if(authorizedCustomer != null){ %>
                              <td>
                                <input type="text" id="address" name="address" placeholder="Enter shipping address" />
                              </td>
                              <td>
                                <button class="mx-3 btn btn-primary" id="orderButton" disabled>Order</button>
                              </td>
                              <%}%>
                        </tr>

                   <% }
                }
                %>

            </tbody>
        </table>
    </div>

    <%@include file="layout/footer.jsp"%>
    <script>
      // Get a reference to the address input and the order button
      var addressInput = document.getElementById("address");
      var orderButton = document.getElementById("orderButton");
    
      // Add an event listener to the address input
      addressInput.addEventListener("input", function() {
        // Check if the address input is not empty
        if (addressInput.value.trim() !== "") {
          // Enable the "Order" button
          orderButton.removeAttribute("disabled");
        } else {
          // Disable the "Order" button
          orderButton.setAttribute("disabled", "disabled");
        }
      });
    </script>
  </body>
</html>
