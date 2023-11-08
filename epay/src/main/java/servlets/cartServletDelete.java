package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import business.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

@jakarta.servlet.annotation.WebServlet("/cartdel")
public class cartServletDelete extends jakarta.servlet.http.HttpServlet{

    protected void doGet(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String slug = request.getParameter("slug");
			if (slug != null) {
				ArrayList<Cart> cl = (ArrayList<Cart>) request.getSession().getAttribute("somelist");
				if (cl != null) {
					for (Cart c : cl) {
						if (c.getSlug() == slug) {
							cl.remove(cl.indexOf(c));
							break;
						}
					}
				}
				response.sendRedirect("cart.jsp");

			} else {
				response.sendRedirect("cart.jsp");
			}

		}
    }
     protected void deDelete(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {

        doGet(request, response);


    }

}