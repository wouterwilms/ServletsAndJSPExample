package be.intecbrussel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Deze Servlet wordt uitgevoerd als er in de web app een
 * NullPointerException wordt gegooid (zie DD)
 */
@WebServlet("/LogNullPointerServlet")
public class LogNullPointerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/nullpointer.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		// Als er een exception voorkomt zullen er heel wat request attributen gemaakt
		// worden waaronder eentje met de naam 'javax.servlet.error.exception'
		// Met deze code wordt dit attirbuut opgevraagd en gecast naar een Throwable.
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		
		/*
		 * De ServletContext heeft een log methode. Deze methode aanvaardt twee argumenten
		 * Een String die de 'fouttekst' voorstelt en een Throwable waarin al de informatie
		 * van de exception zit (Throwable is de base class van al de exceptions).
		 * Bij TomCat zal nu het logbestand in de log folder worden uitgebreid met de
		 * informatie van deze NullPointerException. Hiervoor moet je de website wel buiten
		 * Eclipse starten anders wordt er niets in de log folder geplaatst.
		 */
		this.getServletContext().log("NullPointer", throwable);
		
		dispatcher.forward(request, response);

	}

}
