package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer-logout")
public class CustomerLogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            // "authorized" from CustomerLoginServlet - means customer is logged in
            if (request.getSession().getAttribute("authorizedCustomer") != null) {
                request.getSession().removeAttribute("authorizedCustomer"); // i.e. customer no longer authorized
                response.sendRedirect("customerLogin.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        }
    }
}
