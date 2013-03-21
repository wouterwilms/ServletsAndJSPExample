package be.intecbrussel.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LesVijfServlet")
public class LesVijfServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/requestParameterAndCookie.jsp";
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		String eersteParameter = request.getParameter("eersteParameter");
		
		String tweedeParameter = request.getParameter("tweedeParameter");
		
		request.setAttribute("eersteParameter", eersteParameter);
		
		request.setAttribute("tweedeParameter", tweedeParameter);
		
		// Een header opvragen en als onderdeel van een attribuut meesturen		
		request.setAttribute("userAgent" , "Jij gebruikt " + request.getHeader("user-agent"));
		
		// De headernamen opvragen van al de doorgestuurde headers
		Enumeration<String> headers = request.getHeaderNames();
			
		request.setAttribute("headers", headers);
		
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//een nieuw Cookie object aanmaken: het eerste argument is de naam en het tweede de value
		Cookie cookie = new Cookie ("testCookie", "testValue");
		
		//bepalen hoe lang de cookie blijft bestaan: het argument in een int voor het aantal seconden (in dit geval dus 30 minuten)
		cookie.setMaxAge(60 * 30);
				
		//de cookie toevoegen aan de response zodat deze meegestuurd wordt
		response.addCookie(cookie);
		
		//een tweede cookie
		Cookie cookie2 = new Cookie ("textCookieTwee", "testValueTwee");
		
		cookie.setMaxAge(-1);
		
		response.addCookie(cookie2);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		String[] meerwaardigeParameter = request.getParameterValues("meerWaardigeParameter");
		
		String eersteParameter = request.getParameter("eersteParameter");
		
		String tweedeParameter = request.getParameter("tweedeParameter");
		
		request.setAttribute("eersteParameter", eersteParameter);
		
		request.setAttribute("tweedeParameter", tweedeParameter);
				
		request.setAttribute("meerwaardigeParameter", meerwaardigeParameter);
		
		dispatcher.forward(request, response);
		
	}

}
