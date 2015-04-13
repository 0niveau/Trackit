package com.nico.trackit.dao;

import com.nico.trackit.model.User;
import com.nico.trackit.setup.DatabaseConnectionProvider;

import java.sql.*;

/**
 * Created by Nico on 26.03.2015.
 */
public class UserDAOImpl implements UserDAO {
    private static final String INSERT_USER = "INSERT INTO trackit.user (username, password) VALUES (?,?)";
    private static final String GET_USER_BY_USERNAME = "SELECT id, username, password FROM trackit.user WHERE username = ?;";
    private static final String UPDATE_USER = "UPDATE trackit.user SET username = ?, password = ? WHERE id = ?;";

    private final DatabaseConnectionProvider databaseConnectionProvider;

    public UserDAOImpl(DatabaseConnectionProvider databaseConnectionProvider) {
        this.databaseConnectionProvider = databaseConnectionProvider;
    }

    public boolean createUser(User user) {

        Connection database = databaseConnectionProvider.getTrackItDatabase();
        PreparedStatement createUserStatement = null;

        try {
            createUserStatement = database.prepareStatement(INSERT_USER);
            createUserStatement.setString(1, user.getName());
            createUserStatement.setString(2, user.getPassword());
            if  (createUserStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            // TODO: logging
            e.printStackTrace();
        } finally {
            if (createUserStatement != null) {
                databaseConnectionProvider.closeStatement(createUserStatement);
            }
            databaseConnectionProvider.closeConnection(database);
        }
        return false;
    }

    public User getUserByUsername(String username) {
        Connection database = databaseConnectionProvider.getTrackItDatabase();
        PreparedStatement getUserStatement = null;
        try {
            getUserStatement = database.prepareStatement(GET_USER_BY_USERNAME);
            getUserStatement.setString(1, username);
            ResultSet resultSet = getUserStatement.executeQuery();
            return getUserFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(getUserStatement != null) {
                databaseConnectionProvider.closeStatement(getUserStatement);
            }
            databaseConnectionProvider.closeConnection(database);
        }
        return null;
    }

    public boolean updateUser(User user) {
        Connection database = databaseConnectionProvider.getTrackItDatabase();
        PreparedStatement updateUserStatement = null;
        try {
            updateUserStatement = database.prepareStatement(UPDATE_USER);
            updateUserStatement.setString(1, user.getName());
            updateUserStatement.setString(2, user.getPassword());
            updateUserStatement.setInt(3, user.getUserId());
            if  (updateUserStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(updateUserStatement != null) {
                databaseConnectionProvider.closeStatement(updateUserStatement);
            }
            databaseConnectionProvider.closeConnection(database);
        }
        return false;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException{
        User user = new User();
        user.setUserId(resultSet.getInt("id"));
        user.setName(resultSet.getString("username"));
        return user;
    }
}
