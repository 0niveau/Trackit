package com.nico.trackit.services;

import com.nico.trackit.dao.GroupAccountDAO;
import com.nico.trackit.dao.GroupAccountUserDAO;
import com.nico.trackit.model.GroupAccount;

import javax.inject.Inject;

/**
 * Created by nico on 18.04.15.
 */
public class GroupAccountService {
    private final GroupAccountDAO groupAccountDAO;
    private final GroupAccountUserDAO groupAccountUserDAO;

    @Inject
    public GroupAccountService (GroupAccountDAO groupAccountDAO, GroupAccountUserDAO groupAccountUserDAO){
        this.groupAccountDAO = groupAccountDAO;
        this.groupAccountUserDAO = groupAccountUserDAO;
    }

    public void createGroupAccount(final GroupAccount groupAccount) {
        int groupAccountId = groupAccountDAO.createGroupAccount(groupAccount);
        groupAccountUserDAO.createGroupAccountUsers(groupAccountId, groupAccount.getUsers());
    }
}
