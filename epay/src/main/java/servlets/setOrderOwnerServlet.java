package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import business.*;
import connection.dbConnection;
import dbObjects.OrderObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/setOrderEmail")
public class setOrderOwnerServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String orderIdParam = request.getParameter("orderid");
        String emailParam = request.getParameter("email");

        if (orderIdParam != null && emailParam != null) {
            try {
                int orderId = Integer.parseInt(orderIdParam);
                OrderObject orderObject = new OrderObject(dbConnection.getConnection());

                orderObject.setOrderOwner(orderId, emailParam);

                response.sendRedirect("orders.jsp");
            } catch (Exception e) {
                e.printStackTrace();

                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
