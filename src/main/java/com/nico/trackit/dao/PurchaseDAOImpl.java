package com.nico.trackit.dao;

import com.mysql.jdbc.Statement;
import com.nico.trackit.model.Purchase;
import com.nico.trackit.setup.DatabaseConnectionProvider;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nico on 19.04.15.
 */
public class PurchaseDAOImpl {

    private final DatabaseConnectionProvider databaseConnectionProvider;

    @Inject
    public PurchaseDAOImpl(DatabaseConnectionProvider databaseConnectionProvider) {
        this.databaseConnectionProvider = databaseConnectionProvider;
    }

    public int createPurchase(Purchase purchase) {

        Connection database = databaseConnectionProvider.getTrackItDatabase();
        PreparedStatement createGroupPurchaseStatement = null;

        try {
            createGroupPurchaseStatement = database.prepareStatement("INSERT INTO trackit.groupPurchase (title, purchase_date, user_id) VALUES (?, ? ,?)", Statement.RETURN_GENERATED_KEYS);
            createGroupPurchaseStatement.setString(1, purchase.getTitle());
            createGroupPurchaseStatement.setDate(2, purchase.getPurchaseDate());
            createGroupPurchaseStatement.setInt(3, purchase.getPurchaser().getUserId());
            createGroupPurchaseStatement.executeUpdate();
            ResultSet resultSet = createGroupPurchaseStatement.getGeneratedKeys();
            int purchaseId = resultSet.getInt(1);
            return purchaseId;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if (createGroupPurchaseStatement != null) {
                databaseConnectionProvider.closeStatement(createGroupPurchaseStatement);
            }
            databaseConnectionProvider.closeConnection(database);
        }
        return 0;
    }
}
