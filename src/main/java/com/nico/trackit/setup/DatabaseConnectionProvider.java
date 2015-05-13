package com.nico.trackit.setup;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by Nico on 26.03.2015.
 */

public interface DatabaseConnectionProvider {

    public Connection getTrackItDatabase();

    public void rollbackConnection(Connection connection);

    public void closeConnection(Connection connection);

    public void closeStatement(Statement statement);
}
