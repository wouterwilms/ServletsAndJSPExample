package be.intecbrussel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import be.intecbrussel.entities.Cursist;

public class CursistDAO {

	private static final String FIND_ALL_SQL = "select * from cursist";

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

	private Cursist resultSetRijNaarCursist(ResultSet resultSet)
			throws SQLException {
		return new Cursist(resultSet.getInt("idCursist"),
				resultSet.getString("naam"), resultSet.getInt("cursis"));
	}

}
