package be.intecbrussel.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.intecbrussel.dao.CursistDAO;
import be.intecbrussel.entities.Cursist;

@WebServlet("/CursistServlet")
public class CursistServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/toonCursisten.jsp";
	
	private final CursistDAO cursistDAO = new CursistDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
	ArrayList<Cursist> cursisten = cursistDAO.findAll();
	
	request.setAttribute("cursisten", cursisten);
	
	ArrayList<Cursist> cursistenTwee = new ArrayList<Cursist>();
	
	for (Cursist cursist : cursisten) {
		
		cursistenTwee.add(cursistDAO.read(cursist.getIdCursist()));
		
	}
	
	request.setAttribute("cursistenTwee", cursistenTwee);	
	
	dispatcher.forward(request, response);
	
	}

}
