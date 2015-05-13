package com.nico.trackit.application;

import com.google.inject.Injector;
import com.nico.trackit.resources.AccountResource;
import com.nico.trackit.resources.UserResource;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;
import javax.servlet.ServletContext;

/**
 * Created by Nico on 18.03.2015.
 */
public class TrackItApplication extends ResourceConfig {

    @Inject
    public TrackItApplication(ServiceLocator serviceLocator, ServletContext servletContext) {
        register(AccountResource.class);
        register(UserResource.class);
        register(JacksonFeature.class);

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector((Injector) servletContext.getAttribute(Injector.class.getName()));
    }
}
