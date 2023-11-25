package servlets;

import java.io.IOException;

import business.User;
import dbObjects.RegisterObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/register")
public class registerServlet extends jakarta.servlet.http.HttpServlet {

    private RegisterObject userobj;
	
        public void init() {
            userobj = new RegisterObject();
        }

	protected void doPost(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException, ServletException {


		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String permission = request.getParameter("type");

        User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setPermission(permission);


        try {
			userobj.setCode(user);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	
        response.sendRedirect("register.jsp");
	}
	


}