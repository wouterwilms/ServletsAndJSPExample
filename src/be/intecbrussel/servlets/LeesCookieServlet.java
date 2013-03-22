package be.intecbrussel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LeesCookieServlet")
public class LeesCookieServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	private static final String VIEW = "/WEB-INF/JSP/requestParameterAndCookie.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		//een boolean om te controleren of de testCookie aanwezig is
		boolean testCookieTest = false;
		
		//nagaan of er wel cookies zijn
		if (request.getCookies() != null) {
			
			//al de cookies overlopen en controlleren of de testCookie erbij zit
			for (Cookie cookie:request.getCookies()) {				
				
				if (cookie.getName().equals("testCookie")) {
												
					request.setAttribute("cookieWaarde", "Ja, de cookie value is \"" + cookie.getValue() + "\"");
					
					testCookieTest = true;
									
				}
												
			}					
			
		} 		
		
		//doorgeven als er geen testCookie bestaat
		if (! testCookieTest) {
					
			request.setAttribute("cookieWaarde", "Nee");
						
		}	
		
		dispatcher.forward(request, response);
		
	}

}
