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
    response.sendRedirect("index.jsp");
  }
}