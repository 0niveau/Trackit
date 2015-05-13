package com.nico.trackit.resources;

import com.nico.trackit.dao.GroupAccountDAO;
import com.nico.trackit.model.GroupAccount;
import com.nico.trackit.model.User;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Created by Nico on 18.03.2015.
 */

@Path("account")
public class AccountResource {

    private final GroupAccountDAO groupAccountDAO;

    @Inject
    public AccountResource (GroupAccountDAO groupAccountDAO) {
        this.groupAccountDAO = groupAccountDAO;
    }

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
        if (groupAccountDAO.createGroupAccount(groupAccount) > 0) {
            System.out.println( "created Group Account: " + groupAccount.getTitle());
        } else {
            System.out.println( "could not create Group Account: " + groupAccount.getTitle());
        }
    }
}
