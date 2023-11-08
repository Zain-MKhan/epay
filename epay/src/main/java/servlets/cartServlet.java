package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import business.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@jakarta.servlet.annotation.WebServlet("/cart")
public class cartServlet extends HttpServlet{

    protected void doGet(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {


            ArrayList<Cart> cList = new ArrayList<>();
            int sku = Integer.parseInt(request.getParameter("sku"));
            Cart cartObj = new Cart();
            cartObj.setSku(sku);
            cartObj.setQuantity(1);

            HttpSession session = request.getSession();
            ArrayList<Cart> cl =  (ArrayList<Cart>) session.getAttribute("somelist");

            if (cl == null) {
                cList.add(cartObj);
                session.setAttribute("somelist", cList);
                response.sendRedirect("index.jsp");
                 out.println("testing sessions works ");
            }else{

                cList = cl;
                 boolean stop = false;
                 for (Cart c: cl) {
                    if (c.getSku() == sku) {
                        stop = true;
                        out.println("<h3 text-align: center'>Thing is already in yo Cart. <a href='cart.jsp'>Travel to CART</a></h3>");
                    }
                }

            

            if (!stop) {
                cList.add(cartObj);
                response.sendRedirect("index.jsp");
            }

        }



         }
}
    
}
