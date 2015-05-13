package com.nico.trackit.dao;

import com.nico.trackit.model.GroupAccount;
import com.nico.trackit.model.User;

import java.util.List;

/**
 * Created by Nico on 29.03.2015.
 */
public interface GroupAccountDAO {

    public int createGroupAccount(GroupAccount groupAccount);

    public boolean updateGroupAccount(GroupAccount groupAccount);

    public boolean removeGroupAccount(GroupAccount groupAccount);

    public GroupAccount getGroupAccountById(int groupAccountId);

    public boolean addGroupAccountUser(int groupAccountId, int userId);

    public boolean removeGroupAccountUser(int groupAccountId, int userId);

    public List<User> getGroupAccountUsers(int groupAccountId);

}
