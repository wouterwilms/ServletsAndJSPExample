package be.intecbrussel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * Deze klasse mag enkel toegankelijk zijn vanuit dezelfde
 * package dus verwijder je de acces modifier public waardoor
 * de default acces van toepassing is (package acces) 
 */
class DatabaseUtil {

	/*
	 * Om de datasource op te zoeken gebruik je de JNDI naam van die datasource.
	 * 
	 * JNDI : Java Naming and Directory Interface Dit is een Java API om vanuit
	 * je programma bepaalde objecten op te zoeken met behulp van de naam.
	 * 
	 * In deze contstante geef je de naam mee van het te zoeken object. (in dit
	 * geval de naam van de datasource die we willen gaan gebruiken)
	 * 
	 * De volledige naam van onze datasource bestaat uit twee onderdelen : 
	 * 1.java:/comp/env Dit is de context van de website en dat is een verzameling
	 * resources die op de webserver te vinden is. Onze datasource is 1 van die
	 * resources. 
	 * 2. jdbc/ServletsAndJSPExampleProject : Dit is de naam van onze
	 * datasource, deze naam hebben we bepaald in context.xml in de folder
	 * META-INF.
	 * 
	 * Vrij vertaald betekent de JNDI_NAME hier dus : Zoek in de context van de
	 * website een object met de naam jdbc/ServletsAndJSPExampleProject
	 */
	private static final String JNDI_NAME = "java:/comp/env/jdbc/ServletsAndJSPExampleProject";

	// In deze methode gaan we een connection ophalen uit de datasource van onze website
	public Connection getConnection() {

		// Hier maken we een object-refernce aan van het type javax.naming.Context
		Context context = null;

		try {

			// Hier maken we een javax.naming.InitialContext aan en laten we context refereren naar dit object
			// Zo een object stelt de context van de website voor.
			context = new InitialContext();

			// Hier gebruiken we de lookup() methode van de context om onze datasource op te vragen
			// Je krijgt een een Object terug dat je nog dient te casten naar Datasource.
			DataSource dataSource = (DataSource) context.lookup(JNDI_NAME);

			// Met de methode getConnection() van een DataSource krijgen een van de connecties uit
			// de DataSource terug
			return dataSource.getConnection();

		} 
		
		// Als de JNDI_NAME niet bestaat in de context zal er een NamingException gegooid worden
		catch (NamingException ex) {

			throw new DAOException(JNDI_NAME + " niet gevonden", ex);

		} 
		
		// Als de DataSource geen connectie kan teruggeven zal er een SQLException gegooid worden
		catch (SQLException ex) {

			throw new DAOException("Kan geen connectie krijgen van "
					+ JNDI_NAME, ex);

		} 
		
		// Als we de context niet meer nodig hebben sluiten we deze
		finally {
			try {
				if (context != null) {
					context.close();
				}
			} catch (NamingException ex) {

				throw new DAOException("kan " + JNDI_NAME + " niet sluiten", ex);

			}
		}
	}
	
	
	/*
	 * Als je enkel een Statement en een Connection nodig hebt gehad
	 * in je DAO class kan je deze met deze methode sluiten. (als je
	 * bijvoorbeeld een record hebt (willen) verwijderen) 
	 */
	public void close(Statement statement, Connection connection) {

		if (statement != null) {

			try {

				statement.close();

			} catch (SQLException ex) {
				throw new DAOException("Kan statement niet sluiten", ex);
			}
		}

		if (connection != null) {

			try {

				connection.close();

			} catch (SQLException ex) {
				throw new DAOException("Kan connection niet sluiten", ex);
			}
		}
	}
	
	/*
	 * Als je naast een Statement en een Connection ook een ResultSet
	 * hebt gebruikt kan je deze methode gebruiken om deze objecten te
	 * sluiten. (zodoende moet je in de DAO class maar 1 methode aanroepen) 
	 */
	public void close(ResultSet resultSet, Statement statement,
			Connection connection) {

		if (resultSet != null) {

			try {
				resultSet.close();
			} catch (SQLException ex) {
				throw new DAOException("Kan resultset niet sluiten", ex);
			}
			close(statement, connection);
		}

	}

}
