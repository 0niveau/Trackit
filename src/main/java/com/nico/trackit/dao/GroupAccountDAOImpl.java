package com.nico.trackit.dao;

import com.nico.trackit.model.GroupAccount;
import com.nico.trackit.model.User;
import com.nico.trackit.setup.DatabaseConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nico on 29.03.2015.
 */
public class GroupAccountDAOImpl implements GroupAccountDAO {
    private static final String CREATE_GROUP_ACCOUNT = "INSERT INTO trackit.group_account (name) VALUE (?);";
    private static final String CREATE_FIRST_GROUP_ACCOUNT_USER = "INSERT INTO trackit.group_account_user VALUES (last_insert_id(), ?);";

    private DatabaseConnectionProvider databaseConnectionProvider;

    public GroupAccountDAOImpl (DatabaseConnectionProvider databaseConnectionProvider){
        this.databaseConnectionProvider = databaseConnectionProvider;
    }

    @Override
    public boolean createGroupAccount(GroupAccount groupAccount, User creator) {

        Connection database = databaseConnectionProvider.getTrackItDatabase();
        PreparedStatement createGroupAccountStatement = null;
        PreparedStatement createGroupAccountUserStatement = null;

        try {
            database.setAutoCommit(false);
            createGroupAccountStatement = database.prepareStatement(CREATE_GROUP_ACCOUNT);
            createGroupAccountUserStatement = database.prepareStatement(CREATE_FIRST_GROUP_ACCOUNT_USER);
            createGroupAccountStatement.setString(1, groupAccount.getTitle());
            createGroupAccountUserStatement.setInt(1, creator.getUserId());
            if (createGroupAccountStatement.executeUpdate() > 0 && createGroupAccountUserStatement.executeUpdate() > 0) {
                database.commit();
                return true;
            } else {
                databaseConnectionProvider.rollbackConnection(database);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            databaseConnectionProvider.rollbackConnection(database);
        } finally {
            if (createGroupAccountStatement != null) {
                databaseConnectionProvider.closeStatement(createGroupAccountStatement);
            }
            if (createGroupAccountUserStatement != null) {
                databaseConnectionProvider.closeStatement(createGroupAccountUserStatement);
            }
            databaseConnectionProvider.closeConnection(database);
        }
        return false;
    }

    @Override
    public boolean updateGroupAccount(GroupAccount groupAccount) {
        return false;
    }

    @Override
    public boolean removeGroupAccount(GroupAccount groupAccount) {
        return false;
    }

    @Override
    public GroupAccount getGroupAccountById(int groupAccountId) {
        return null;
    }

    @Override
    public boolean addGroupAccountUser(int groupAccountId, int userId) {
        return false;
    }

    @Override
    public boolean removeGroupAccountUser(int groupAccountId, int userId) {
        return false;
    }

    @Override
    public List<User> getGroupAccountUsers(int groupAccountId) {
        return null;
    }
}
