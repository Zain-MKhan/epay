package servlets;

import java.io.IOException;

import business.Customer;
import connection.dbConnection;
import dbObjects.RegisterObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/change")
public class changePasscodeServlet extends jakarta.servlet.http.HttpServlet {

	protected void doPost(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			RegisterObject robj = new RegisterObject(dbConnection.getConnection());

			Customer user = new Customer();
			user.setEmail(email);
			user.setPassword(password);
			robj.updateCode(user);

			System.out.println("Successfully updated password!");

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

		response.sendRedirect("customerLogin.jsp");
	}
}