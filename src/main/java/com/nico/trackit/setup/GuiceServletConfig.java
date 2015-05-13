package com.nico.trackit.setup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.nico.trackit.modules.DevelopmentModule;
import com.nico.trackit.modules.TrackitServletModule;

/**
 * Created by nico on 18.04.15.
 */
public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new DevelopmentModule(), new TrackitServletModule());
    }
}
