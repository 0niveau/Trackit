package com.nico.trackit.modules;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nico on 18.04.15.
 */
public class TrackitServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        Map<String, String> jerseyParams = new HashMap<>();
        jerseyParams.put("javax.ws.rs.Application", "com.nico.trackit.application.TrackItApplication");

        bind(ServletContainer.class).in(Singleton.class);

        serve("/*").with(ServletContainer.class, jerseyParams);
    }
}
