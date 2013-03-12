package be.intecbrussel.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ToonEnVerwerkFormServlet")
public class ToonEnVerwerkFormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	
	private static final String GETVIEW = "/WEB-INF/JSP/eenJSPMetEenForm.jsp";

	private static final String POSTVIEW = "/WEB-INF/JSP/eenJSPAlsPOSTRequestResultaat.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(GETVIEW);
		
		// Primitief type doorgeven aan JSP		
		request.setAttribute("cursisten", 6);
		
		// Object type doorgeven aan JSP 
		String cursisten = "zes";
		request.setAttribute("cursistenStringObject", cursisten);
		
		// Array doorgeven aan JSP
		request.setAttribute("instructeursArray", new String[] {"Mohamed", "Kenneth", "Kevin"});
		
		// List doorgenen aan JSP
		List<String> instructeursList = Arrays.asList("Mohamed", "Kenneth", "Kevin");
		request.setAttribute("instructeursList", instructeursList);
		
		// Map doorgeven aan JSP
		Map<String, String> eigenschappen = new HashMap<String, String>();
		eigenschappen.put("Java", "awesome");
		eigenschappen.put(".NET", "notSoAwesome");
		request.setAttribute("eigenschappen", eigenschappen);
		
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(POSTVIEW);
		
		// De form parameter "naam" opvragen uit de request en toekennen aan een nieuw String object
		String naam = request.getParameter("naam");
		
		request.setAttribute("naam", naam);
		
		dispatcher.forward(request, response);		
		
	}

}
