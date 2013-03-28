package be.intecbrussel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.intecbrussel.dao.DAOException;
import be.intecbrussel.dao.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/userRegister.jsp";
	
	// om de user toe te voegen hebben we een UserDAO nodig
	private final UserDAO userDAO = new UserDAO();
	
	// een boolean om aan te geven dat het toevoegen mislukt is
	private boolean addError = false;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.setAttribute("userNotFound", false);
		
		session.setAttribute("wrongPassword", false);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Initieel is er geen error
		addError = false;
		
		// De userName opvragen
		String userName = request.getParameter("registerUserName");
		
		// Het paswoord opvragen
		String pwd = request.getParameter("registerPassword");
		
		// Proberen om met deze gegevens een nieuwe gebruiker 
		// toe te voegen
		try {
		
		// userDAO gebruiken om dit te proberen
		userDAO.addOne(userName, pwd);
		
		} catch (DAOException ex) {
			
			// Als het toevoegen mislukt geven we dit aan
			// (voor simpliciteit gaan we er van uit dat
			// dit enkel kan gebeuren als de gebruikersnaam
			// al bestaat, deze heeft namelijk een uniqueness
			// constraint in de DB)
			addError = true;
			
		}
		
		// Als het toevoegen is gelukt
		if (!addError) {
					
			// Sturen we de gebruiker naar de login pagina om in te loggen met zijn 
			// nieuwe userName en Password
			response.sendRedirect(request.getServletContext().getContextPath() + "/UserServlet");
									
		}
		
		else {
			
			// anders sturen we hem terug naar de registratie pagina met een foutmelding			
			RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
			
			request.setAttribute("addError", true);
			
			dispatcher.forward(request, response);
			
		}
		
		
	}

}
