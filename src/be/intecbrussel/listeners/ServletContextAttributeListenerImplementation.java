package be.intecbrussel.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


/*
 * In deze listener krijgen al de methodes een object mee van de klasse
 * ServletContextAttributeEvent. Deze klasse bevat de volgende methodes :
 * +getName(): String
 * +getValue(): Object
 */

@WebListener
public class ServletContextAttributeListenerImplementation implements ServletContextAttributeListener {


    public void attributeAdded(ServletContextAttributeEvent event) {
    	
    	String name = event.getName();
    	
    	System.out.println("A servlet context attribute was added with name: " + name );
    	
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
    	
    	String name = event.getName();

    	
    	System.out.println("A servlet context attribute was adjusted with name: " + name );

    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
    	
    	String name = event.getName();
    	
    	System.out.println("A servlet context attribute was removed with name: " + name );

    }
	
}
