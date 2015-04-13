package com.nico.trackit.resources;

import com.nico.trackit.dao.UserDAO;
import com.nico.trackit.dao.UserDAOImpl;
import com.nico.trackit.model.User;
import com.nico.trackit.setup.DatabaseConnectionProviderImpl;

import javax.ws.rs.*;

/**
 * Created by Nico on 18.03.2015.
 */
@Path("user")
public class UserResource {

    private final UserDAO userDAO;

    public UserResource() {
        this.userDAO = new UserDAOImpl(new DatabaseConnectionProviderImpl());
    }

    @POST
    @Consumes("application/json")
    public String createUser (User user){
        if (userDAO.createUser(user)) {
            return "yei";
        } else {
            return "oh nooooo";
        }
    }

    @Path("/{userId}")
    @PUT
    @Consumes("application/json")
    public String updateUser(@PathParam("userId") int userId, User user) {
        if (userDAO.updateUser(user)) {
            return "update successful";
        } else {
            return "update failed";
        }
    }
}
