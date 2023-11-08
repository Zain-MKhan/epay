package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import business.Product;
import connection.dbConnection;
import dbObjects.ProductObject;
import jakarta.servlet.ServletException;

@jakarta.servlet.annotation.WebServlet("/products")
public class productsServlet extends jakarta.servlet.http.HttpServlet {

  protected void doGet(jakarta.servlet.http.HttpServletRequest request,
      jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
        
        
        ProductObject pdobj;
        try {
            pdobj = new ProductObject(dbConnection.getConnection());

                 response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Products List</h1>");  

         List<Product> products = pdobj.getAllProducts(); 

         out.print("<table border='1' width='100%'");  
         out.print("<tr><th>getSku</th><th>Name</th><th>getDescription</th></tr>");  
         for(Product p:products){  
            out.print("<tr><td>"+p.getSku()+"</td><td>"+p.getName()+"</td><td>"+p.getDescription()+"</td><td>");  
           }  

           out.print("</table>");  
          
           out.close();  
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
   


    
      }



}