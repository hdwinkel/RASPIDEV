package com.ikea.vaexabox;

import org.skife.jdbi.v2.DBI;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.db.RegistrationDAO;
import com.ikea.vaexabox.resources.GetCount;
import com.ikea.vaexabox.resources.PostAccept;
import com.ikea.vaexabox.resources.PostBreak;
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
    
    	String location=configuration.getRaspi();
		SQLiteConnectionPoolDataSource ds = new SQLiteConnectionPoolDataSource();
		ds.setUrl(configuration.getDburl());
		DBI jdbi = new DBI(ds);
    	final EventDAO eventdao = jdbi.onDemand(EventDAO.class);
    	final RegistrationDAO registrationdao = jdbi.onDemand(RegistrationDAO.class);
    	
        environment.jersey().register(new PostEvent(eventdao));
        environment.jersey().register(new PostAccept(eventdao));
        environment.jersey().register(new PostRegistration(registrationdao));
        environment.jersey().register(new GetCount(eventdao, location));
        environment.jersey().register(new PostBreak(registrationdao));
        
    }

}
