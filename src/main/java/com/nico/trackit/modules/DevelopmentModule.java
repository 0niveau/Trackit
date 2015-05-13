package com.nico.trackit.modules;

import com.google.inject.AbstractModule;
import com.nico.trackit.dao.*;
import com.nico.trackit.setup.DatabaseConnectionProvider;
import com.nico.trackit.setup.DatabaseConnectionProviderImpl;

/**
 * Created by nico on 18.04.15.
 */
public class DevelopmentModule extends AbstractModule {

    public void configure() {
        bind(DatabaseConnectionProvider.class).to(DatabaseConnectionProviderImpl.class);

        bind(GroupAccountDAO.class).to(GroupAccountDAOImpl.class);
        bind(GroupAccountUserDAO.class).to(GroupAccountUserDAOImpl.class);
        bind(UserDAO.class).to(UserDAOImpl.class);
    }
}
