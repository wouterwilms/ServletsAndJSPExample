package be.intecbrussel.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/*
 * In deze listener krijgen al de methodes een object mee van de klasse
 * ServletContextEvent. Deze klasse bevat de volgende methodes :
 * +getServletContext(): ServletContext
 */

@WebListener
public class ServletContextListenerImplementation implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
    	
    	String name = event.getServletContext().getServletContextName();
    	
    	System.out.println("A servlet context has been created for web application: " + name );
    	
    }

    public void contextDestroyed(ServletContextEvent event) {
    	
    	String name = event.getServletContext().getServletContextName();
    	
    	System.out.println("A servlet context has been removed: " + name );
    	
    }
	
}
