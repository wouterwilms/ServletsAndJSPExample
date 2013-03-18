package be.intecbrussel.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NullPointerServlet")
public class NullPointerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Deze code dient enkel en alleen om een NullPointerException te genereren
		
		String nullPointer = request.getParameter("geenParameter");
		
		nullPointer.toString();
		
	}

}
