package be.intecbrussel.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


/*
 * In deze listener krijgen al de methodes een object mee van de klasse
 * HttpSessionBindingEvent. Deze klasse bevat de volgende methodes :
 * +getName(): String
 * +getValue(): Object
 * +getSession(): HttpSession
 */

@WebListener
public class FilmSessionAttributeListener implements HttpSessionAttributeListener {

	// iedere keer als er een attribuut wordt verwijderd van een session
	// wordt deze methode aangeroepen
	public void attributeRemoved(HttpSessionBindingEvent evint) {

	}

	// iedere keer als er een attribuut wordt toegevoegd aan een session
	// wordt deze methode aangeroepen
	public void attributeAdded(HttpSessionBindingEvent event) {

		if (event.getName().equals("bestellingen")) {

			verhoogBestellingTeller(event.getSession().getServletContext());

		}

	}

	private synchronized void verhoogBestellingTeller(
			ServletContext servletContext) {
		Integer bestellingTeller = (Integer) servletContext
				.getAttribute("aantal_bestellingen");
		if (bestellingTeller == null) {
			bestellingTeller = 1;
		} else {
			bestellingTeller++;
		}
		servletContext.setAttribute("aantal_bestellingen", bestellingTeller);
		
		System.out.println("Aantal gebruikers die de lijst met filmvoorstellingen bekeken heeft :  " + bestellingTeller);
		
	}

	// iedere keer als er een attribuut wordt aangepast in een session
	// wordt deze methode aangeroepen
	public void attributeReplaced(HttpSessionBindingEvent event) {

	}

}
