package be.intecbrussel.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NumberOfSessionsServlet")
public class NumberOfSessionsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession(true);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("WEB-INF/JSP/showNumberOfSessions.jsp");

		RequestDispatcher dispatcher2 = request
				.getRequestDispatcher("WEB-INF/JSP/toManySessions.jsp");

		Integer numberOfSessions = (Integer) this.getServletContext()
				.getAttribute("numberOfSessions");
		

		if (numberOfSessions < 5) {

			request.setAttribute("numberOfSessions", numberOfSessions);

			dispatcher.forward(request, response);

		} else {
			
						
			ArrayList<HttpSession> sessions = (ArrayList<HttpSession>) this.getServletContext().getAttribute("sessions");

			sessions.removeAll(sessions);
			
			dispatcher2.forward(request, response);

		}

	}

}
