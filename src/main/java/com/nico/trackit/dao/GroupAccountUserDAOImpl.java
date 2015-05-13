package com.nico.trackit.dao;

import com.google.inject.Inject;
import com.nico.trackit.model.User;
import com.nico.trackit.setup.DatabaseConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by nico on 18.04.15.
 */
public class GroupAccountUserDAOImpl implements GroupAccountUserDAO{

    private final DatabaseConnectionProvider databaseConnectionProvider;

    @Inject
    public GroupAccountUserDAOImpl(DatabaseConnectionProvider databaseConnectionProvider) {
        this.databaseConnectionProvider = databaseConnectionProvider;
    }

    public int createGroupAccountUsers(int groupAccountId, Set<User> users) {
        Connection database = databaseConnectionProvider.getTrackItDatabase();
        PreparedStatement createGroupAccountUserStatement = null;

        try {
            createGroupAccountUserStatement = database.prepareStatement("INSERT INTO trackit.group_account_user VALUES (?,?);");
            for (User user : users) {
                createGroupAccountUserStatement.setInt(1, groupAccountId);
                createGroupAccountUserStatement.setInt(2, user.getUserId());
                createGroupAccountUserStatement.addBatch();
            }
            int[] updateCounts = createGroupAccountUserStatement.executeBatch();
            int affectedRows = 0;
            for(int i = 0; i < updateCounts.length; i++) {
                affectedRows += i;
            }
            return affectedRows;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (createGroupAccountUserStatement != null) {
                databaseConnectionProvider.closeStatement(createGroupAccountUserStatement);
            }
            databaseConnectionProvider.closeConnection(database);
        }
        return 0;
    }
}
