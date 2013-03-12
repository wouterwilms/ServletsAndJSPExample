package be.intecbrussel.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.intecbrussel.entities.FilmTicket;

@WebServlet("/FilmTicket")
public class FilmTicketServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "WEB-INF/JSP/filmTickets.jsp";

	private static final String REDIRECT_URL = "/FilmTicket";

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);

		HttpSession session = request.getSession(true);

		ArrayList<FilmTicket> voorstellingen = (ArrayList<FilmTicket>) session
				.getAttribute("voorstellingen");

		ArrayList<FilmTicket> bestellingen = (ArrayList<FilmTicket>) session
				.getAttribute("bestellingen");

		if (bestellingen == null) {

			bestellingen = new ArrayList<FilmTicket>();

			session.setAttribute("bestellingen", bestellingen);

		}

		if (voorstellingen == null) {

			voorstellingen = new ArrayList<FilmTicket>();

			voorstellingen.add(new FilmTicket("eersteFilm", 120, 1,
					new BigDecimal(10)));

			voorstellingen.add(new FilmTicket("tweedeFilm", 120, 1,
					new BigDecimal(10)));

			voorstellingen.add(new FilmTicket("derdeFilm", 120, 1,
					new BigDecimal(10)));

			voorstellingen.add(new FilmTicket("vierdeFilm", 120, 1,
					new BigDecimal(10)));

			voorstellingen.add(new FilmTicket("vijfdeFilm", 120, 1,
					new BigDecimal(10)));

			session.setAttribute("voorstellingen", voorstellingen);

		}

		request.setAttribute("voorstellingen", voorstellingen);

		request.setAttribute("bestellingen", bestellingen);

		dispatcher.forward(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		ArrayList<FilmTicket> voorstellingen = (ArrayList<FilmTicket>) session
				.getAttribute("voorstellingen");

		ArrayList<FilmTicket> bestellingen = (ArrayList<FilmTicket>) session
				.getAttribute("bestellingen");

		FilmTicket gekozenVoorstelling = null;

		if (request.getParameter("taak").equals("bestellen")) {

			for (FilmTicket ticket : voorstellingen) {

				if (request.getParameter(ticket.getTitel()) != null) {

					gekozenVoorstelling = ticket;

				}

			}

			if (gekozenVoorstelling != null) {

				voorstellingen.remove(gekozenVoorstelling);

				bestellingen.add(gekozenVoorstelling);

			}

		} else {

			for (FilmTicket ticket : bestellingen) {

				if (request.getParameter(ticket.getTitel()) != null) {

					gekozenVoorstelling = ticket;

				}

			}

			if (gekozenVoorstelling != null) {

				bestellingen.remove(gekozenVoorstelling);

				voorstellingen.add(gekozenVoorstelling);

			}

		}

		session.setAttribute("voorstellingen", voorstellingen);

		session.setAttribute("bestellingen", bestellingen);

		response.sendRedirect(response.encodeRedirectURL(request
				.getContextPath() + REDIRECT_URL));

	}

}
