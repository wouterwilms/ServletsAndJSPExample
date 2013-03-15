package be.intecbrussel.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/*
 * In deze listener krijgen al de methodes een object mee van de klasse
 * ServletRequestEvent. Deze klasse bevat de volgende methodes :
 * +getServletRequest(): ServletRequest
 * +getServletContext(): ServletContext
 */

@WebListener
public class ServletRequestListenerImplementation implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent event) {
    	
    	String remoteAdress = event.getServletRequest().getRemoteAddr();
    	
    	int port = event.getServletRequest().getServerPort();
    	
    	System.out.println("A request from " + remoteAdress + " coming in through port " + port + " has been removed");
    	
    }

    public void requestInitialized(ServletRequestEvent event) {
    	
    	String remoteAdress = event.getServletRequest().getRemoteAddr();
    	
    	int port = event.getServletRequest().getServerPort();
    	
    	System.out.println("A request from " + remoteAdress + " coming in through port " + port + " has been created");
    	
    }
	
}
