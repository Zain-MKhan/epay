package servlets;

import java.io.IOException;
import connection.dbConnection;
import dbObjects.CustomerObject;
import dbObjects.StaffObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/revokeStaffPrivileges")
public class revokeStaffPrivilegesServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String emailParam = request.getParameter("email");

        if (emailParam != null) {
            try {
                CustomerObject customerObject = new CustomerObject(dbConnection.getConnection());
                StaffObject staffObject = new StaffObject(dbConnection.getConnection());

                customerObject.revokeStaffPrivileges(emailParam);
                staffObject.removeStaffMember(emailParam);

                response.sendRedirect("manageStaffPrivileges.jsp");
            } catch (Exception e) {
                e.printStackTrace();

                response.sendRedirect("error.jsp");
            }
        }
    }
}
