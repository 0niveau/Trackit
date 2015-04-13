package com.nico.trackit.dao;

import com.nico.trackit.model.User;

/**
 * Created by Nico on 26.03.2015.
 */
public interface UserDAO {

    public boolean createUser(User user);

    public User getUserByUsername(String username);

    public boolean updateUser(User user);
}
