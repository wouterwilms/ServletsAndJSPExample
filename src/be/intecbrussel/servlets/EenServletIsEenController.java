// Een controller kan commando's sturen naar een view om dynamische content weer te geven

// Om wat meer structuur in een web app te krijgen zet je de servlets best in een aparte
// package. Nu is dat misschien wat overbodig maar later (als er een model, database, ...
// bijkomt) zal het nut van deze taktiek werkwijze bewezen worden.
package be.intecbrussel.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Met deze annotatie associeer je de servlet met een URL.
//Dit vervangt de registratie van de servlet in de Deployment Descriptor(DD).
@WebServlet("/EenServletIsEenController")
public class EenServletIsEenController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Het is een goede gewoonte om de VIEW (een JSP) die gelinkt 
	 * is aan een servlet te declareren in een constante. Een servlet
	 * en een JSP vormen meestal een vast koppel.
	 * Je zet je JSP ook best in een aparte folder die onder WEB-INF staat.
	 * WEB-INF is een folder waar de bezoeker van de site niet aan kan maar
	 * een servlet wel. Bezoekers moeten niet de code van de JSP kunnen lezen
	 * maar enkel de resulterende HTML die ze ontvangen in de response.
	 */	
	private static final String VIEW = "/WEB-INF/JSP/eenJSPIsEenView.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Een dispatcher verkrijgen van de request en er een JSP mee associeren
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
	    // Een simpele dynamische boodschap genereren
		// Een groet die afhangt van het uur van de dag
		String message;
		
		Calendar calendar = Calendar.getInstance();
		int uur = calendar.get(Calendar.HOUR_OF_DAY);
		if (uur >= 6 && uur < 12) {
		message = "Goede morgen,";
		} else if (uur >= 12 && uur < 18) {
		message = "Goede middag,";
		} else {
		message = "Goede avond,";
		}
		
		// een attribuut toevoegen aan de request
		request.setAttribute("naamDieInJSPKanAangesprokenWorden", message);
		
		// de request forwarden naar de JSP
		dispatcher.forward(request, response);
		
	}

}
