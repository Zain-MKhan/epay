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
import jakarta.servlet.http.HttpSession;

@WebServlet("/check-out")
public class checkOutServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("check out servlet");

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());

            ArrayList<Cart> cl = (ArrayList<Cart>) request.getSession().getAttribute("somelist");

            Customer authorizedCustomer = (Customer) request.getSession().getAttribute("authorizedCustomer");

            if (cl != null && authorizedCustomer != null) {
                for (Cart c : cl) {
                    Order order = new Order();
                    order.setSku(c.getSku());
                    order.setEmail(authorizedCustomer.getEmail());
                    order.setQuantity(c.getQuantity());
                    order.setDate(dateFormatter.format(date));
                    order.setShippingAddress(c.getShippingAddress());

                    OrderObject orderObject = new OrderObject(dbConnection.getConnection());
                    boolean result = orderObject.insertOrder(order);
                    if (!result) {
                        System.out.println("failed to add to db");
                        break;
                    }
                    System.out.println("added to db!");
                }
                cl.clear();
                response.sendRedirect("orders.jsp");
            } else if (authorizedCustomer == null) {
                response.sendRedirect("customerLogin.jsp");
            } else {
                response.sendRedirect("cart.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
