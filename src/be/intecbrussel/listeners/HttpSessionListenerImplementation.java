package be.intecbrussel.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/*
 * In deze listener krijgen al de methodes een object mee van de klasse
 * HttpSessionEvent. Deze klasse bevat de volgende methodes :
 * +getSession(): HttpSession
 */

@WebListener
public class HttpSessionListenerImplementation implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent event) {
    	
    	String id = event.getSession().getId();
    	
    	System.out.println("A session was created with id: " + id );
    	
    }

    
    public void sessionDestroyed(HttpSessionEvent event) {
    	
    	String id = event.getSession().getId();
    	
    	System.out.println("A session was removed with id: " + id );
    	
    }
	
}
