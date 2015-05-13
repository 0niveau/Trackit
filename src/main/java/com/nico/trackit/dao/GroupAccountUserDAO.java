package com.nico.trackit.dao;

import com.nico.trackit.model.User;

import java.util.Set;

/**
 * Created by nico on 18.04.15.
 */
public interface GroupAccountUserDAO {

    public int createGroupAccountUsers (int groupAccount, Set<User> users);
}
