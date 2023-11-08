package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/staff-logout")
public class StaffLogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            // "authorized" from StaffLoginServlet - means staff is logged in
            if (request.getSession().getAttribute("authorizedStaff") != null) {
                request.getSession().removeAttribute("authorizedStaff"); // i.e. staff no longer authorized
                response.sendRedirect("staffLogin.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        }
    }
}
