package com.ikea.vaexabox;

import com.ikea.vaexabox.resources.HelloResource;
import com.ikea.vaexabox.resources.PostEvent;
import com.ikea.vaexabox.resources.PostRegistration;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DWGettingStartedApplication extends Application<DWGettingStartedConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DWGettingStartedApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWGettingStarted";
    }

    @Override
    public void initialize(final Bootstrap<DWGettingStartedConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DWGettingStartedConfiguration configuration,
            final Environment environment) {
        environment.jersey().register(new HelloResource());
        environment.jersey().register(new PostEvent());
        environment.jersey().register(new PostRegistration());
    }

}
