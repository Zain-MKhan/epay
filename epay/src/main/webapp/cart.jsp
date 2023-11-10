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
    <title>Cart</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>
    <div class="container">
        <div class=" d-flex py-3"><h3>Welcome to the Cart Page</h3></div>
        <div class="card">
          <div class="card-body d-flex justify-content-between">
            <div>
              <h3 class="card-title">Total Price: </h3>
              <h3 class="card-text"><%=request.getAttribute("total")%></h3>
            </div>
              <%if(authorizedCustomer != null && cl!=null && cl.size()>=1){ %>
                <form action="shippingAddress" method="get">
                  <div>
                      <input type="text" id="address" name="address" placeholder="Enter shipping address" />
                  </div>
                  <button type="submit" class="mx-3 btn btn-primary" id="addressButton" disabled>Confirm address</button>
              </form>              
              <button class="mx-3 btn btn-primary" id="orderButton" disabled>Order</button>
              <%}else if(authorizedCustomer != null && (cl!=null || cl.size()<1)){%>
                <h3 class="card-text">Add items to cart to place order</h3>
              <%}else {%>
                <h3 class="card-text">Login to place order!</h3>
              <%}%>
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
                  
                                  <a class="btn btn-sm btn-incre" href="cartDec/<%=c.getSku()%>"><i class="fas fa-minus-square"></i></a>
                                  <input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly>
                                  <a class="btn btn-sm btn-incre" href="cartInc/<%=c.getSku()%>"><i class="fas fa-plus-square"></i></a>
                                </div>
                                </form>
                              </td>

                              <td>
                                <a class="mx-3 btn btn-primary" href="cartdel?slug=<%=c.getSlug()%>">Remove</a>
                              </td>
                        </tr>

                   <% }
                }
                %>

            </tbody>
        </table>
    </div>

    <%@include file="layout/footer.jsp"%>
    <script>
      var addressInput = document.getElementById("address");
      var addressButton = document.getElementById("addressButton");
      var orderButton = document.getElementById("orderButton");
    
      addressInput.addEventListener("input", function() {
        if (addressInput.value.trim() !== "") {
          addressButton.removeAttribute("disabled");
        } else {
          addressButton.setAttribute("disabled", "disabled");
        }
      });
    
      addressButton.addEventListener("click", function(event) {
        event.preventDefault(); // Prevent the default action of the button
    
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "shippingAddress?address=" + addressInput.value, true);
        xhr.onreadystatechange = function() {
          if (xhr.readyState === 4 && xhr.status === 200) {
            orderButton.removeAttribute("disabled");
          }
        };
        xhr.send();
    
        return false;
      });
    
      orderButton.setAttribute("disabled", "disabled");
      orderButton.addEventListener("click", function() {
        window.location.href = "check-out"; // Redirect to checkout when the button is clicked
      });
    </script>
    
  </body>
</html>
