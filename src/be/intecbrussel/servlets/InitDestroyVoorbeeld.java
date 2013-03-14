package be.intecbrussel.servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
 * Als je voor een Servlet init parameters wilt vastleggen in de DD (web.xml)
 * moet je de servlet een naam geven waarmee je de servlet in de DD kan aanspreken.
 * Je geeft je servlet een naam door de @webServlet annotatie aan te passen.
 * Je geeft niet meer enkel 1 string door die het URL pattroon aangeeft maar
 * je geeft twee attributen 'urlPatters' en 'name'.
 */
@WebServlet(urlPatterns = "/InitDestroyVoorbeeld", name = "initDestroyVoorbeeld")
public class InitDestroyVoorbeeld extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String cursus;

	private int aantalCursisten;

	/*
	 * Als je in de constructor een waarde geeft aan de velden van de Servlet
	 * kan een niet-programmeur deze waarde niet aanpassen. Daarom dat je beter
	 * init parameters gebruikt zodoende dat een niet programmeur (of een programmeur
	 * die niet over de broncode beschikt) deze waarde toch kan aanpassen.
	 */
	public InitDestroyVoorbeeld() {

		this.cursus = "onbestaande";

		System.out.println("Servlet instance is created !");

		System.out.println("Field values after contructor : \n De cursus is "
				+ cursus + "\n Het aantal cursisten is " + aantalCursisten);

	}
	
	/*
	 * Deze methode wordt uitgevoerd bij de initialisatie van de Servlet.
	 * In deze methode kan je gebruik maken van de init paramaters die je
	 * bepaald hebt in de DD. je doet dat met de methode 'getInitParameter'
	 * en je geeft als argument de naam van de gewenste parameter. Als deze
	 * parameter niet bestaat zal er 'null' worden teruggegeven. 
	 */
	@Override
    public void init() throws ServletException {
    	
    	this.cursus = this.getInitParameter("cursus");
    	
    	// De init parameters zijn van het type String dus kan je niet zomaar int waarden opvragen.
    	this.aantalCursisten = Integer.valueOf(this.getInitParameter("aantalCursisten"));
    	
    	System.out.println("Field values after init method : \n De cursus is " + cursus + "\n Het aantal cursisten is " + aantalCursisten );
    	
    	// Hier wordt de ServletContext opgevraagd (dit object maakt het mogelijk om servlets te laten
    	// communiceren met hun servlet container om er onder andere het path van op te vragen (zoals
    	// hier wordt gedaan) maar je kan er ook attributen en init parameters in opslaan die dan in alle
    	// servlets van de web app kunnen aangesproken worden.
    	ServletContext context = this.getServletContext();
    	
    	// Hier wordt een bestand aangemaakt in de WEB-INF folder
    	File file = new File( context.getRealPath("/WEB-INF/eenTextBestand.txt"));
    	
    	try {
    	
    	FileWriter writer = new FileWriter(file);
    	
    	writer.write("Ik ben aangemaakt in de init methode");
    					
    	writer.close();
    	
    	} catch (IOException ex) {System.out.println("Niets kunnen schrijven");}
    			
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
    	this.getServletContext().setInitParameter("nieuwAttribuut", "Ik ben een servlet context attribuut en ben zopas geset geweest door de doGet methode van InitDestroyVoorbeeld");

		System.out.println("Dit is de initparameter uit de servlet context die " +
				"het opleidingscentrum bevat : " + this.getServletContext().getInitParameter("opleidingsCentrum"));
		
		response.sendRedirect(request.getContextPath() + "/IndexServlet");

	}


	/*
	 *  Deze methode wordt uitgevoerd als de Servlet verwijderd wordt en als de
	 *  webserver gestopt wordt. In dit geval wordt het bestand dat gemaakt is in
	 *  de init methode terug verwijderd.
	 */
	@Override
	public void destroy() {
		
    	ServletContext context = this.getServletContext();
		
    	File file = new File( context.getRealPath("/WEB-INF/eenTextBestand.txt"));
    	
    	file.delete();
    	
	}

}
