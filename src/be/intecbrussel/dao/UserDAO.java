package be.intecbrussel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.intecbrussel.entities.User;
import be.intecbrussel.util.Security;

public class UserDAO {

	private static final String FIND_USER = "select * from users where userName = ?";

	private static final String ADD_ONE = "insert into users values(null, ?, ?)";

	private final DatabaseUtil databaseUtil = new DatabaseUtil();
	
	private final Security security = new Security();

	public User findOne(String userName) {

		Connection connection = null;

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			connection = databaseUtil.getConnection();

			statement = connection.prepareStatement(FIND_USER);
			
			statement.setString(1, userName);

			resultSet = statement.executeQuery();

			return resultSetRijNaarUser(resultSet);

		} catch (SQLException ex) {

			throw new DAOException("Kan user niet lezen uit database", ex);

		} finally {

			databaseUtil.close(resultSet, statement, connection);
		}

	}

	public void addOne(String userName, String pwd) {

		Connection connection = null;

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {

			connection = databaseUtil.getConnection();

			statement = connection.prepareStatement(ADD_ONE);
			
			statement.setString(1, userName);

			statement.setString(2, security.heavyHash(pwd));

			statement.executeUpdate();

		} catch (SQLException ex) {

			throw new DAOException("Kan de user niet toevoegen aan de database", ex);

		}

		finally {

			databaseUtil.close(resultSet, statement, connection);

		}

	}

	private User resultSetRijNaarUser(ResultSet resultSet) throws SQLException {

		resultSet.next();

		return new User(resultSet.getInt("idUsers"),
				resultSet.getString("userName"), resultSet.getString("userPW"));
	}

}
