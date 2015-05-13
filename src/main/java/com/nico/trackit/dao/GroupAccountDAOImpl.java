package com.nico.trackit.dao;

import com.google.inject.Inject;
import com.mysql.jdbc.Statement;
import com.nico.trackit.model.GroupAccount;
import com.nico.trackit.model.User;
import com.nico.trackit.setup.DatabaseConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nico on 29.03.2015.
 */
public class GroupAccountDAOImpl implements GroupAccountDAO {
    private static final String CREATE_GROUP_ACCOUNT = "INSERT INTO trackit.group_account (name) VALUE (?);";

    private DatabaseConnectionProvider databaseConnectionProvider;

    @Inject
    public GroupAccountDAOImpl (DatabaseConnectionProvider databaseConnectionProvider){
        this.databaseConnectionProvider = databaseConnectionProvider;
    }

    @Override
    public int createGroupAccount(GroupAccount groupAccount) {

        Connection database = databaseConnectionProvider.getTrackItDatabase();
        PreparedStatement createGroupAccountStatement = null;

        try {
            createGroupAccountStatement = database.prepareStatement(CREATE_GROUP_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
            createGroupAccountStatement.setString(1, groupAccount.getTitle());
            createGroupAccountStatement.executeUpdate();
            ResultSet resultSet = createGroupAccountStatement.getGeneratedKeys();
            int groupAccountId = resultSet.getInt(1);
            return groupAccountId;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (createGroupAccountStatement != null) {
                databaseConnectionProvider.closeStatement(createGroupAccountStatement);
            }
            databaseConnectionProvider.closeConnection(database);
        }
        return 0;
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
