package be.intecbrussel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.intecbrussel.dao.DAOException;
import be.intecbrussel.dao.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/userRegister.jsp";
	
	private final UserDAO userDAO = new UserDAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean addError = false;
		
		String userName = request.getParameter("registerUserName");
		
		String pwd = request.getParameter("registerPassword");
		
		try {
		
		userDAO.addOne(userName, pwd);
		
		} catch (DAOException ex) {
			
			addError = true;
			
		}
		
		if (!addError) {
			
			response.sendRedirect(request.getServletContext().getContextPath() + "/UserServlet");
									
		}
		
		else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
			
			request.setAttribute("addError", true);
			
			dispatcher.forward(request, response);
			
		}
		
		
	}

}
