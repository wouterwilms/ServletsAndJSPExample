/*
 * Het is aan te raden om bij elke entity class een corresponderende
 * DAO class aan te maken. Deze broncode is voor de corresponderende
 * DAO class van be.intecbrussel.entities.Cursist 
 */

package be.intecbrussel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import be.intecbrussel.entities.Cursist;

public class CursistDAO {
	
	/*
	 * De specifieke SQL queries declareer je best
	 * bovenaan in je class als constanten. 
	 */
	private static final String FIND_ALL_SQL = "select * from cursist";

	private static final String READ_SQL = "select * from cursist where idCursist = ?";
	
	/*
	 * Elke DAO class die correspondeerd met een entity gaat 
	 * gebruik maken van de DatabaseUtil dus maken we er een
	 * final field voor.
	 */
	private final DatabaseUtil databaseUtil = new DatabaseUtil();

	public ArrayList<Cursist> findAll() {

		Connection connection = null;

		Statement statement = null;

		ResultSet resultSet = null;

		try {

			ArrayList<Cursist> cursisten = new ArrayList<Cursist>();

			connection = databaseUtil.getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(FIND_ALL_SQL);

			while (resultSet.next()) {
				cursisten.add(resultSetRijNaarCursist(resultSet));
			}

			return cursisten;
		} catch (SQLException ex) {

			throw new DAOException("Kan cursisten niet lezen uit database", ex);

		} finally {

			databaseUtil.close(resultSet, statement, connection);

		}

	}
	
	public Cursist read(int idCursist) {
		
		Connection connection = null;
		
		PreparedStatement statement = null;
		
		ResultSet resultSet = null;
		
		try {
			
			Cursist cursist = null;
			
			connection = databaseUtil.getConnection();
			
			statement = connection.prepareStatement(READ_SQL);
			
			statement.setInt(1, idCursist);
			
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				
				cursist = resultSetRijNaarCursist(resultSet);
				
			}
			
			return cursist;
			
		} catch (SQLException ex) {
			
			throw new DAOException("Kan cursist niet lezen uit database", ex);
			
		} finally {
			
			databaseUtil.close(resultSet, statement, connection);
			
		}
		
	}
	
	/*
	 * Omdat je in meerdere methodes in deze class een ResultSet
	 * moet omzetten naar een Cursist is hier een methode 
	 * geimplementeerd die dit voor zijn rekening neemt. 
	 */
	private Cursist resultSetRijNaarCursist(ResultSet resultSet)
			throws SQLException {
		return new Cursist(resultSet.getInt("idCursist"),
				resultSet.getString("naam"), resultSet.getInt("cursis"));
	}

}
