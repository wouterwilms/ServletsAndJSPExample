package be.intecbrussel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOut")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String REDIRECT_URL = "/IndexServlet";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Als er een session aanwezig is wordt dit if-block uitgevoerd
		if (session != null) {
			
			// Met dit statement kan je een session onmiddelijk verwijderen.
			// Dus voor dat de session-timeout bereikt is. (zie DD (web.xml))
			session.invalidate();
			
		}
		
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + REDIRECT_URL));
		
	}

}
