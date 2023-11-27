<%@page import="connection.dbConnection" %>
<%@page import="dbObjects.CustomerObject" %>

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
    List<Customer> customerList = null;
    if (authorizedStaff!=null){
        request.setAttribute("authorizedStaff", authorizedStaff);
        CustomerObject customerObject = new CustomerObject(dbConnection.getConnection());
        customerList = customerObject.allCustomers();
    } 
%>    

<!doctype html>
<html lang="en">
  <head>
    <title>Epay</title>
    <%@include file="layout/header.jsp"%>
  </head>
  <body>
    <%@include file="layout/navbar.jsp"%>

    <div class="container">
        <div class=" d-flex py-3"><h3>Grant/Revoke Staff Privileges</h3></div>

        <table class="table table-light">
            <thead>
              <tr>
                <th scope="col">User</th>
                <th scope="col">Staff Membership</th>
              </tr>
            </thead>
            <tbody>
                <%
                if(customerList != null){
                  for(Customer c:customerList){
                    if (c.getEmail().equals(authorizedStaff.getUserName())){
                        continue;
                    }%>
                    <tr>
                      <td><%= c.getEmail() %></td>
                      <td>
                        <% if (c.getIsStaff().equals("false")) { %>
                            <form action="grantStaffPrivileges" method="post">
                                <div>
                                    <input type="hidden" name="email" value="<%= c.getEmail() %>">
                                </div>
                                <button type="submit" class="mx-3 btn btn-primary" id="grantStaffButton">Click to grant staff privileges</button>
                            </form>
                        <%} else if (c.getIsStaff().equals("true")) { %>
                            <form action="revokeStaffPrivileges" method="post">
                                <div>
                                    <input type="hidden" name="email" value="<%= c.getEmail() %>">
                                </div>
                                <button type="submit" class="mx-3 btn btn-danger" id="revokeStaffButton">Click to revoke staff privileges</button>
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