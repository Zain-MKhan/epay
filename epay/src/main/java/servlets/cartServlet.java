package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import business.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

@jakarta.servlet.annotation.WebServlet("/cart")
public class cartServlet extends jakarta.servlet.http.HttpServlet{

    protected void doGet(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {


            ArrayList<Cart> cList = new ArrayList<>();
            String slug = request.getParameter("slug");
            Cart cartObj = new Cart();
            cartObj.setSlug(slug);
            cartObj.setQuantity(1);

        
            
            HttpSession session = request.getSession();
            ArrayList<Cart> cl =  (ArrayList<Cart>) session.getAttribute("somelist");

            if (cl == null) {
                cList.add(cartObj);
                session.setAttribute("somelist", cList);
               response.sendRedirect("cart.jsp");
                 out.println("testing sessions works just go back for now.  ");
            }
            else{

                out.println("testing sessions if lands here ti will works.works ");
                cList = cl;
                boolean stop = false;

                
                for(Cart c: cList){

                    if (c.getSlug()==slug){
                        stop=true;
                        out.println("<h3 text-align: center'>Thing is already in yo Cart. <a href='cart.jsp'>Travel to CART</a></h3>");


                    }

                }
                        if(!stop){
                        cl.add(cartObj);
                        response.sendRedirect("cart.jsp");
                        out.println("lets see if we added the prodcus.");

                    }
            }
             for(Cart c: cList){
                out.println(c.getSlug());
             }



         }
}
 protected void doPost(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
    doGet(request, response);


 }
    
}
