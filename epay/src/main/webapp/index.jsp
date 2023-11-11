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

ArrayList<Cart> somelist = (ArrayList<Cart>) session.getAttribute("somelist");
  if (somelist != null) {
      request.setAttribute("somelist", somelist);
  }  
%>

<!doctype html>
<html lang="en">
  <head>
    <title>Epay</title>
    <%@include file="layout/header.jsp"%>
    <link href="index.css" rel="stylesheet" type="text/css"/>

  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>

          <h1 class="headerText">Product Display</h1>
          <div class = "container">
            <div class="row">
                <%
                if(!products.isEmpty()){
                    for (Product p: products){%>
                      <div class="col-sm-4">
                        <div class="card">
                          <img class="card-img-top" src=<%=p.getImage()%> alt="img" style="width: 100%; height: 400px;">
                          <div class="card-body">
                            <h5 class="card-title"><%=p.getName() %></h5>
                            <h5 class="price"><%=p.getPrice() %></h5>
                            <h5 class="vendor"><%=p.getVendor() %></h5>
                            <p class="card-text"><%=p.getDescription() %></p>
                            <div class=" mt-3 d-flex justify-content-between">
                              <a href="products/<%=p.getSlug()%>" class="btn btn-primary">View product</a>
                              <%if(authorizedStaff == null){ %>
                                <a href="cart?slug=<%=p.getSlug()%>&sku=<%=p.getSku()%>" class="btn btn-primary">Add to cart</a>
                              <%}%>
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



<footer class="bg-dark text-center text-white">
   
    <!-- Grid container -->
    <div class="container p-4 pb-0">
      <!-- Section: Social media -->
      <section class="mb-4">
        <!-- Facebook -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
          ><i class="fab fa-facebook-f"></i
        ></a>
  
        <!-- Twitter -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
          ><i class="fab fa-twitter"></i
        ></a>
  
        <!-- Google -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
          ><i class="fab fa-google"></i
        ></a>
  
        <!-- Instagram -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
          ><i class="fab fa-instagram"></i
        ></a>
  
        <!-- Linkedin -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
          ><i class="fab fa-linkedin-in"></i
        ></a>
  
        <!-- Github -->
        <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
          ><i class="fab fa-github"></i
        ></a>
      </section>
      <!-- Section: Social media -->
    </div>
    <!-- Grid container -->
  
   
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
     Team Epay
    </div>

  
  </footer>

  </body>
</html>