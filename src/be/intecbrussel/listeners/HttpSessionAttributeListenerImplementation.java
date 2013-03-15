package be.intecbrussel.listeners;

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
public class HttpSessionAttributeListenerImplementation implements HttpSessionAttributeListener {

    public void attributeRemoved(HttpSessionBindingEvent event) {
    	
    	String name = event.getName();
    	
    	System.out.println("A session attribute was removed with name: " + name );
    	
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
    	
    	String name = event.getName();
    	
    	System.out.println("A session attribute was added with name: " + name );
    	
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
    	
    	String name = event.getName();
    	
    	System.out.println("A session attribute was adjusted with name: " + name );
    	
    }
	
}
