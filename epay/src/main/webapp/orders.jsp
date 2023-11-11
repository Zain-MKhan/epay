<%@page import="connection.dbConnection" %>
<%@page import="dbObjects.OrderObject" %>
<%@page import="business.*" %>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Customer authorizedCustomer = (Customer) request.getSession().getAttribute("authorizedCustomer"); 
    List<Order> customerOrders = null;
    if (authorizedCustomer!=null){
        request.setAttribute("authorizedCustomer", authorizedCustomer);
        customerOrders = new OrderObject(dbConnection.getConnection()).userOrders(authorizedCustomer.getEmail());
    } 
%>
<% Staff authorizedStaff = (Staff) request.getSession().getAttribute("authorizedStaff"); 
    if (authorizedStaff!=null){
        request.setAttribute("authorizedStaff", authorizedStaff);
        customerOrders = new OrderObject(dbConnection.getConnection()).allOrders();
    } 

ArrayList<Cart> somelist = (ArrayList<Cart>) session.getAttribute("somelist");
  if (somelist != null) {
      request.setAttribute("somelist", somelist);
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
        <div class=" d-flex py-3"><h3>Welcome to the Orders Page</h3></div>

        <table class="table table-light">
            <thead>
              <tr>
                <th scope="col">Order ID</th>
                <th scope="col">Product SKU</th>
                <th scope="col">Quantity</th>
                <th scope="col">Shipping Address</th>
                <th scope="col">Date</th>
                <th scope="col">User</th>
                <th scope="col">Tracking Number</th>
              </tr>
            </thead>
            <tbody>
                <%
                if(customerOrders != null){
                  for(Order o:customerOrders){%>
                    <tr>
                      <td><%= o.getOrderId() %></td>
                      <td><%= o.getSku() %></td>
                      <td><%= o.getQuantity() %></td>
                      <td><%= o.getShippingAddress() %></td>
                      <td><%= o.getDate() %></td>
                      <td><%= o.getEmail() %></td>
                      <td><%= o.getTrackingNumber() %>
                        <%if(o.getTrackingNumber() != 0){ %>
                          <h5>Shipped!</h5>
                        <%}%>
                        <%if(authorizedStaff != null && o.getTrackingNumber() == 0){ %>
                          <form action="shipOrder" method="get">
                            <div>
                                <input type="text" id="trackingNumber%>" name="trackingNumber" placeholder="Enter Tracking Number" />
                                <input type="hidden" name="orderId" value="<%= o.getOrderId() %>">
                              </div>
                            <button type="submit" class="mx-3 btn btn-primary" id="shipButton%>">Ship Order</button>
                          </form>
                        <%}%>
                      </td>
                    </tr>
                    
                  <%}
                }%>
            </tbody>
        </table>
    </div>

    <%@include file="layout/footer.jsp"%>

    
  </body>
</html>