package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import business.*;
import connection.dbConnection;
import dbObjects.OrderObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet("/shipOrder")
public class shippingServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        // try (PrintWriter out = response.getWriter()) {
        // out.println("ship order servlet");
        // }

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int trackingNumber = Integer.parseInt(request.getParameter("trackingNumber"));

        try {
            OrderObject orderObject = new OrderObject(dbConnection.getConnection());
            orderObject.updateTrackingNumber(orderId, trackingNumber);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("orders.jsp");
    }
}