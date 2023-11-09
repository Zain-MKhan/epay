package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import business.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartq")
public class cartQuantityServlet extends jakarta.servlet.http.HttpServlet{

    protected void doGet(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {     

			String act = request.getParameter("act");
            
			int sku = Integer.parseInt(request.getParameter("sku"));
			ArrayList<Cart> cl = (ArrayList<Cart>) request.getSession().getAttribute("somelist");
			if (act != null && sku >= 1) {
				if (act.equals("inc")) {
					for (Cart c : cl) {
						if (c.getSku() == sku) {
							int q = c.getQuantity();
							q++;
							c.setQuantity(q);
							response.sendRedirect("cart.jsp");
						}
					}
				}
				if (act.equals("dec")) {
					for (Cart c : cl) {
						if (c.getSku() == sku && c.getQuantity() > 1) {
							int q = c.getQuantity();
							q--;
							c.setQuantity(q);
							break;
						}
					}
					response.sendRedirect("cart.jsp");
				}
                
			} else {
				response.sendRedirect("cart.jsp");
			}
		}
	}




          
 }


