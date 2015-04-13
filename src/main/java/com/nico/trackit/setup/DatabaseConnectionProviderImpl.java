package com.nico.trackit.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nico on 26.03.2015.
 */
public class DatabaseConnectionProviderImpl implements DatabaseConnectionProvider{

    private static final String TRACK_IT_DATABASE_URL = "jdbc:mysql://localhost/trackit?user=trackituser&password=trackit123";

    public Connection getTrackItDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection(TRACK_IT_DATABASE_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Could not register database driver");
            e.printStackTrace();
        }
        return null;
    }
    public void rollbackConnection (Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println("Could not rollback database connection");
            e.printStackTrace();
        }
    }
    public void closeConnection(Connection connection)  {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Could not close database connection");
            e.printStackTrace();
        }
    }

    public void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Could not close statement");
            e.printStackTrace();
        }
    }
}
