package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import business.Staff;
import connection.dbConnection;
import dbObjects.StaffObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/staff-login")
public class StaffLoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("staffLogin.jsp"); // will redirect if anyone tries to access via URL
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String userName = request.getParameter("login-staff-user"); // getting from the form in the staffLogin.jsp
            String password = request.getParameter("login-staff-password");// getting from the same form

            try {
                StaffObject staffDBObject = new StaffObject(dbConnection.getConnection());
                Staff staff = staffDBObject.staffLogin(userName, password);
                if (staff != null) {
                    request.getSession().setAttribute("authorizedStaff", staff);
                    response.sendRedirect("index.jsp");
                } else {
                    out.print("Staff login failed");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            out.print(userName + password);
        }
    }
}
