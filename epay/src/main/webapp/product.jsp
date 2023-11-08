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
ProductObject pdobj = new ProductObject(dbConnection.getConnection());
List<Product> products = pdobj.getAllProducts();   
%>

<%
String slug = (String) session.getAttribute("slug");
%>
<!doctype html>
<html lang="en">
  <head>
    <title>Epay</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>

    <%
      if(!products.isEmpty()){
        for (Product p: products){
          if(p.getSlug().equals(slug)){%>
            <div class="card" style="width: 50%;">
              <img src=<%=p.getImage()%> class="card-img-top" alt="img" style="width: 50%; height: auto;">
              <div class="card-body">
                <h4 class="card-title"><%=p.getName() %></h4>
                <h5 class="card-text"><%=p.getVendor()%></h5>
                <p class="card-text"><%=p.getDescription() %></p>

                <% if(authorizedStaff != null){%>
                  <a href="#" class="btn btn-primary">Update product details</a>
                <%}%>
              </div>
            </div>
          <%break;
          }
        }
      }
    %>
    <% out.print(dbConnection.getConnection());%>
    <%@include file="layout/footer.jsp"%>
  </body>
</html>