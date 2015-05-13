package com.nico.trackit.resources;

import com.nico.trackit.dao.UserDAO;
import com.nico.trackit.model.User;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Created by Nico on 18.03.2015.
 */
@Path("user")
public class UserResource {

    private final UserDAO userDAO;

    @Inject
    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @POST
    @Consumes("application/json")
    public String createUser (User user){
        if (userDAO.createUser(user) > 0) {
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
