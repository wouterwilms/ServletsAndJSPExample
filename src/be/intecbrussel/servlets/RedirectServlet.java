package be.intecbrussel.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eersteParameter = request.getParameter("eersteParameter");
		
		String tweedeParameter = request.getParameter("tweedeParameter");
		
		System.out.println("De eerste parameter : " + eersteParameter);
		
		System.out.println("De tweede parameter : " + tweedeParameter);
		
		response.sendRedirect("JSTLServlet");
		
	}

}
