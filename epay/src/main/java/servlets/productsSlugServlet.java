package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@jakarta.servlet.annotation.WebServlet("/products/*")
public class productsSlugServlet extends jakarta.servlet.http.HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the user is already on "cart.jsp"
        // Get the slug from the request URL
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            // Remove the leading slash and split the path into parts
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length > 1) {
                String slug = pathParts[1]; // The slug is the second part
                request.getSession().setAttribute("slug", slug);
            }
        }

        // Redirect to "product.jsp"
        response.sendRedirect(request.getContextPath() + "/product.jsp");
    }

    protected void doPost(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {

    }

}
