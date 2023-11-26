<%@ page isELIgnored="false" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="products">Epay</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="products">Home</a>
          </li>
         
          <%if(authorizedCustomer != null){ %>
            <li class="nav-item">
              <a class="nav-link" href="cart.jsp">Cart <span class="badge bg-secondary">${somelist.size()}</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="orders.jsp">Orders</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="changePasscode.jsp">changePasscode</a>
            </li>
            <li>
              <a class="nav-link" href="claimOrder.jsp">Claim Order</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="customer-logout">Logout</a>
            </li>
          <%}else if(authorizedStaff != null){ %>
            <li class="nav-item">
              <a class="nav-link" href="orders.jsp">Orders</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="createProduct.jsp">Create new product</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="downloadCatalog.jsp">Download product catalog</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="changePasscode.jsp">changePasscode</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="staff-logout">Staff Logout</a>
            </li>
          <%}else{ %>
            <li class="nav-item">
              <a class="nav-link" href="cart.jsp">Cart <span class="badge bg-secondary">${somelist.size()}</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="customerLogin.jsp">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="staffLogin.jsp">Staff Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="register.jsp">SetPasscode</a>
            </li>
          <% } %>
        </ul>
      </div>
    </div>
  </nav>