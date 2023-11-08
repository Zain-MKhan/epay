package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;

@jakarta.servlet.annotation.WebServlet("/products")
public class productsServlet extends jakarta.servlet.http.HttpServlet {

  protected void doGet(jakarta.servlet.http.HttpServletRequest request,
      jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {
    response.sendRedirect("index.jsp");
  }
}