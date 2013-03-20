/*
 * Bij het communiceren met een database kunnen exceptions optreden.
 * In ons geval zijn dit exceptions van het type 'SQLException'.
 * Deze exceptions zullen onstaan in de DAO-layer van je applicatie.
 * Als je in de Servlet gebruik maakt van de DAO-layer en er
 * treedt een Exception op zou je informatie over die Exception
 * willen kunnen krijgen. Daarom catch je de Exceptions in de servlet.
 * 
 * Als je deze Exceptions opvangt als SQLExceptions zorg je ervoor
 * dat je servlets hard coded zijn om met JDBC te werken. Dit wil
 * je niet omdat er ook nog andere bibliotheken zijn waarmee je
 * databases kunt aanspreken en die bibliotheken hebben andere
 * Exceptions. 
 * 
 * Om ervoor te zorgen dat de Servlet-layer onafhankelijk is van de
 * gekozen database bibliotheek moeten we een generische Exception 
 * opvangen. Het is deze Exception die in dit .java bestand is uitgeschreven.
 * 
 * In de DAO-layer (deze is wel bibliotheek specifiek) vang je de 
 * SQLExceptions op waarna je in het catchblok een generische exception
 * 'DAOException' gooit. Zodoende kan de Servlet gewoon DAOExceptions 
 * catchen en niet de bibliotheek-specifieke SQL-Exceptions! 
 */


package be.intecbrussel.dao;

public class DAOException extends RuntimeException {
	
	/*
	 * RuntimeException is een Serializable class dus
	 * moet* je een constante SerialVersionUID meegeven.
	 * Deze constante dient als versienummer van de class.
	 * Dit heeft zijn nut in volgend scenario:
	 * 
	 * 1. Je schrijft een serializable class, maakt daar
	 * objecten van aan en schrijft deze objecten weg
	 * naar een DB.
	 * 
	 * 2. Je veranderd de class op een ingrijpende manier
	 * waardoor objecten van de vorige versie niet meer compatibel
	 * zijn. Daarom verander je ook het versienummer (serialVersionUID).
	 * 
	 * 3. Als jij (of iemand anders) later de objecten uit de DB
	 * probeert te importeren in de applicaties zal dit tegengehouden
	 * worden omdat de serialVersionUID niet overeenkomt!
	 * 
	 * * In principe moet dit niet omdat Java ook een default 
	 *   SerialversionUID kan aanmaken als dit niet door de 
	 *   programmeur wordt aangemaakt. Maar het wordt aangeraden
	 *   omdat default SerialVersionUID praktisch nooit het gewenste 
	 *   resultaat zal geven.
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Een constructor die een foutmelding (String) 
	 * als argument meekrijgt om deze aan de constructor
	 * van de superclass te geven.
	 */
	public DAOException ( String message ) {
		
		super (message);
		
	}
	
	/* 
	 * Een constructor die een foutmelding (String) en de oorspronkelijke
	 * Exception (Throwable) als argumenten meekrijgt. 
	 * Zodoende kan je in een Servlet de oorsprongkelijke exception
	 * lezen met de methode 'getCause()'. Dit kan de servlet gebruiken
	 * om informatie over de exception weg te schrijven naar een logbestand
	 */
	public DAOException ( String message, Throwable cause ) {
		
		super (message, cause);
		
	}
	
}
