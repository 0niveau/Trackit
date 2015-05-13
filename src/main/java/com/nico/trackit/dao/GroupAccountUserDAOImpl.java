package com.nico.trackit.dao;

import com.nico.trackit.model.GroupAccount;
import com.nico.trackit.model.User;
import com.nico.trackit.setup.DatabaseConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by nico on 18.04.15.
 */
public class GroupAccountUserDAOImpl {

    private final DatabaseConnectionProvider databaseConnectionProvider;

    public GroupAccountUserDAOImpl(DatabaseConnectionProvider databaseConnectionProvider) {
        this.databaseConnectionProvider = databaseConnectionProvider;
    }

    public boolean createGroupAccountUser(GroupAccount groupAccount, User user) {
        Connection database = databaseConnectionProvider.getTrackItDatabase();
        PreparedStatement createGroupAccountUserStatement = null;

        try {
            createGroupAccountUserStatement = database.prepareStatement("INSERT INTO trackit.group_account_user VALUES (?,?);");
            createGroupAccountUserStatement.setInt(1, groupAccount.getId());
            createGroupAccountUserStatement.setInt(2, user.getUserId());
            createGroupAccountUserStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (createGroupAccountUserStatement != null) {
                databaseConnectionProvider.closeStatement(createGroupAccountUserStatement);
            }
            databaseConnectionProvider.closeConnection(database);
        }
        return false;
    }
}
