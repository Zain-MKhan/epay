package servlets;

import java.io.IOException;
import connection.dbConnection;
import dbObjects.OrderObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/claimOrder")
public class claimOrderServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String orderIdParam = request.getParameter("orderid");
        String emailParam = request.getParameter("email");

        if (orderIdParam != null && emailParam != null) {
            try {
                int orderId = Integer.parseInt(orderIdParam);
                OrderObject orderObject = new OrderObject(dbConnection.getConnection());

                // Call the claimOrder method with orderid and emailParam
                orderObject.claimOrder(orderId, emailParam);

                // Redirect to a success page or perform any other action
                response.sendRedirect("orders.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                // Handle the case where orderIdParam is not a valid integer
                response.sendRedirect("error.jsp");
            }
        } else {
            // Handle the case where orderIdParam or emailParam is null
            response.sendRedirect("error.jsp");
        }
    }
}
