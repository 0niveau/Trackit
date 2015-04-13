package com.nico.trackit.resources;

import com.nico.trackit.dao.GroupAccountDAO;
import com.nico.trackit.dao.GroupAccountDAOImpl;
import com.nico.trackit.model.GroupAccount;
import com.nico.trackit.model.GroupPurchaseItem;
import com.nico.trackit.model.User;
import com.nico.trackit.setup.DatabaseConnectionProviderImpl;

import javax.ws.rs.*;

/**
 * Created by Nico on 18.03.2015.
 */

@Path("account")
public class AccountResource {

    private final GroupAccountDAO groupAccountDAO;

    public AccountResource () { this.groupAccountDAO = new GroupAccountDAOImpl(new DatabaseConnectionProviderImpl());}

    @GET
    public String getResourceName() {
        return "AccountsResource";
    }

    @POST
    @Consumes("application/json")
    public void createGroupAccount(GroupAccount groupAccount,@QueryParam("userId") int userId) {
        System.out.println("received a groupAccount");
        User creatingUser = new User();
        creatingUser.setUserId(userId);
        if (groupAccountDAO.createGroupAccount(groupAccount, creatingUser)) {
            System.out.println( "created Group Account: " + groupAccount.getTitle());
        } else {
            System.out.println( "could not create Group Account: " + groupAccount.getTitle());
        }
    }
}
