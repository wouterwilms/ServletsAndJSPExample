package be.intecbrussel.listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * In deze listener krijgen al de methodes een object mee van de klasse
 * HttpSessionEvent. Deze klasse bevat de volgende methodes :
 * +getSession(): HttpSession
 */
@SuppressWarnings("unchecked")
@WebListener
public class HttpSessionListenerImplementation implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent event) {

		ServletContext servletContext = event.getSession().getServletContext();

		ArrayList<HttpSession> sessions = (ArrayList<HttpSession>) servletContext.getAttribute("sessions");
		
		if (sessions == null) {
			
			sessions = new ArrayList<HttpSession>();
			
		}
		
		sessions.add(event.getSession());
		
		Integer numberOfSessions = (Integer) servletContext
				.getAttribute("numberOfSessions");

		if (numberOfSessions == null) {

			numberOfSessions = 0;

		}

		numberOfSessions++;
				
		servletContext.setAttribute("numberOfSessions", numberOfSessions);
		
		servletContext.setAttribute("sessions", sessions);

		String id = event.getSession().getId();

		System.out.println("A session was created with id: " + id);

	}

	public void sessionDestroyed(HttpSessionEvent event) {

		ServletContext servletContext = event.getSession().getServletContext();
		
		ArrayList<HttpSession> sessions = (ArrayList<HttpSession>) servletContext.getAttribute("sessions");
		
		sessions.remove(event.getSession());

		Integer numberOfSessions = (Integer) servletContext
				.getAttribute("numberOfSessions");

		numberOfSessions--;
		
		servletContext.setAttribute("numberOfSessions", numberOfSessions);
		String id = event.getSession().getId();

		System.out.println("A session was removed with id: " + id);

	}

}
