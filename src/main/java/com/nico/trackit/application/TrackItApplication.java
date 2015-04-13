package com.nico.trackit.application;

import com.nico.trackit.resources.AccountResource;
import com.nico.trackit.resources.UserResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by Nico on 18.03.2015.
 */
public class TrackItApplication extends ResourceConfig {
    public TrackItApplication() {
        register(AccountResource.class);
        register(UserResource.class);
        register(JacksonFeature.class);
    }
}
