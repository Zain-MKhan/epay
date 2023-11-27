package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import business.Customer;
import connection.dbConnection;
import dbObjects.CustomerObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer-login")
public class CustomerLoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("customerLogin.jsp"); // will redirect if anyone tries to access via URL
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("login-email"); // getting from the form in the login.jsp
            String password = request.getParameter("login-password"); // getting from the form in the login.jsp

            try {
                CustomerObject customerDBObject = new CustomerObject(dbConnection.getConnection());
                // for login with email
                // Customer customer = customerDBObject.customerLogin(email, password);

                Customer customer = customerDBObject.customerLogin(password);
                if (customer != null) {
                    request.getSession().setAttribute("authorizedCustomer", customer);
                    response.sendRedirect("index.jsp");
                } else {
                    out.print("Customer login failed");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            out.print(email + password);
        }
    }
}
