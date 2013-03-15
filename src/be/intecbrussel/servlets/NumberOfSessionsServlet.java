package be.intecbrussel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NumberOfSessionsServlet")
public class NumberOfSessionsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("WEB-INF/JSP/showNumberOfSessions.jsp");

		RequestDispatcher dispatcher2 = request
				.getRequestDispatcher("WEB-INF/JSP/toManySessions.jsp");

		Integer numberOfSessions = (Integer) this.getServletContext()
				.getAttribute("numberOfSessions");
		
		if (numberOfSessions == null) {
			
			numberOfSessions = 0;			
		}

		if (numberOfSessions < 5) {

			request.setAttribute("numberOfSessions", ++numberOfSessions);

			request.getSession(true);

			dispatcher.forward(request, response);

		} else {

			request.getSession().invalidate();

			dispatcher2.forward(request, response);

		}

	}

}
