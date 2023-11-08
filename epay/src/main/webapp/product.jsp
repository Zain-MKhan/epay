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
<%
    
ProductObject pdobj = new ProductObject(dbConnection.getConnection());
List<Product> products = pdobj.getSku();   
%>

<!doctype html>
<html lang="en">
  <head>
    <title>Epay</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>

          <h1>Products</h1>
          <div class = "container">
            <div class="row">
                <%
                if(!products.isEmpty()){
                    for (Product p: products){%>
                      <div class="col-sm-4">
                        <div class="card">
                          <img class="card-img-top" src=<%=p.getImage()%> alt="img" style="width: 100%; height: 400px;">
                          <div class="card-body">
                            <h5 class="card-title"><%=p.getSku() %></h5>
                            <div class=" mt-3 d-flex justify-content-between">
                               <a href="cart.jsp" class="btn btn-primary">Add to cart</a>
                            </div>
                          </div>
                        </div>
                      </div>
                  <%}
                }else {
                    out.println("none");
                    }
                %>
            </div>
          </div>
              <% out.print(dbConnection.getConnection());%>
              <%@include file="layout/footer.jsp"%>
  </body>
</html>