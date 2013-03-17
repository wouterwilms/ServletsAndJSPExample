package be.intecbrussel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/voorbeeldFilter")
public class VoorbeeldFilterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final String VIEW = "WEB-INF/JSP/filterVoorbeeld.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		dispatcher.forward(request, response);
		
		
	}

}
