package be.intecbrussel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.intecbrussel.dao.CursistDAO;

@WebServlet("/CursistServlet")
public class CursistServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/toonCursisten.jsp";
	
	private final CursistDAO cursistDAO = new CursistDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
	request.setAttribute("cursisten", cursistDAO.findAll());
	
	dispatcher.forward(request, response);
	
	}

}
