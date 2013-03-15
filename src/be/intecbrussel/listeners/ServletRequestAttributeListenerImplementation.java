package be.intecbrussel.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;


/*
 * In deze listener krijgen al de methodes een object mee van de klasse
 * ServletRequestAttributeEvent. Deze klasse bevat de volgende methodes :
 * +getName(): String
 * +getValue(): Object
 */

@WebListener
public class ServletRequestAttributeListenerImplementation implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent event) {
    	
    	String name = event.getName();
    	
    	System.out.println("A request attribute has been created with name: " + name );
    	
    }

    public void attributeRemoved(ServletRequestAttributeEvent event) {
    	
    	String name = event.getName();

    	System.out.println("A request attribute has been removed with name: " + name );
    	
    }

    public void attributeReplaced(ServletRequestAttributeEvent event) {
    	
    	String name = event.getName();

    	System.out.println("A request attribute has been adjusted with name: " + name );
    	
    }
	
}
