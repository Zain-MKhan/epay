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

@WebServlet("/cartDec/*")
public class cartQuantityDecreaseServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        // Get the sku and action from the request URL
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            // Remove the leading slash and split the path into parts
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length > 1) {
                String sku = pathParts[1]; // The sku is the second part
                int skuInt = Integer.parseInt(sku);
                ArrayList<Cart> somelist = (ArrayList<Cart>) session.getAttribute("somelist");

                // Check for the increment action
                if (skuInt >= 1) {
                    System.out.println("Your skuInt is " + skuInt);
                    for (Cart c : somelist) {
                        if (c.getSku() == skuInt) {
                            int quantity = c.getQuantity();
                            if (quantity == 1) {
                                somelist.remove(c);
                                session.setAttribute("somelist", somelist);
                                break;
                            }
                            quantity -= 1;
                            c.setQuantity(quantity);
                            session.setAttribute("somelist", somelist);
                            System.out.println("Quantity for " + sku + " decremented to: " + quantity);
                            break;
                        }
                        System.out.println("Never found your sku!" + somelist.toString());
                    }
                }
            }
        }

        // Redirect to "cart.jsp"
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
}