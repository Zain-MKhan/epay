package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import business.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/shippingAddress")
public class shippingAddressServlet extends jakarta.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Cart> somelist = (ArrayList<Cart>) session.getAttribute("somelist");
        String address = request.getParameter("address");
        for (Cart c : somelist) {
            c.setShippingAddress(address);
            System.out.println("The shipping address added to the cart is " + address);
            session.setAttribute("somelist", somelist);
        }
        session.setAttribute("somelist", somelist);

        response.sendRedirect("cart.jsp");
    }

}