package com.ikea.vaexabox;

import org.skife.jdbi.v2.DBI;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

import com.ikea.vaexabox.core.DisplayMessages;
import com.ikea.vaexabox.db.DisplayDAO;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.db.MannedDAO;
import com.ikea.vaexabox.db.RegistrationDAO;
import com.ikea.vaexabox.mail.TLSMail;
import com.ikea.vaexabox.resources.GetCount;
import com.ikea.vaexabox.resources.GetDisplay;
import com.ikea.vaexabox.resources.PostAccept;
import com.ikea.vaexabox.resources.PostBreak;
import com.ikea.vaexabox.resources.PostDisplay;
import com.ikea.vaexabox.resources.PostEvent;
import com.ikea.vaexabox.resources.PostManned;
import com.ikea.vaexabox.resources.PostRegistration;
import com.ikea.vaexabox.tools.Helper;

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
    	final DisplayDAO displaydao = jdbi.onDemand(DisplayDAO.class);
    	final MannedDAO manneddao = jdbi.onDemand(MannedDAO.class);
    	TLSMail tlsm = new TLSMail(configuration.getSmtphost(), configuration.getSmtpport(), configuration.getSmtpuser(), configuration.getSmtppassword());
    	boolean mustSendMail = ((configuration.getSendmail().equals("1"))?true:false);
    	
    	DisplayMessages dm = new DisplayMessages(
    			configuration.getInitDisplay1(), 
    			configuration.getInitDisplay2(), 
    			configuration.getOnEventDisplay1(),
    			configuration.getOnEventDisplay2(),
    			configuration.getOnAcceptDisplay1(),
    			configuration.getOnAcceptDisplay2(),
    			configuration.getOnMannedDisplay1(),
    			configuration.getOnMannedDisplay2()
    			);
    	
    	displaydao.delete();
    	displaydao.insertDisplayMessage(Helper.getUUID(), dm.getInitDisplay1(), dm.getInitDisplay2(), Helper.getCurrentTimeStampAsTS());
    	manneddao.delete();
    	manneddao.insertIsManned(1, 0, Helper.getCurrentTimeStampAsTS());
    	
    	environment.jersey().register(new PostEvent(eventdao, registrationdao, displaydao, manneddao, mustSendMail, tlsm, location,dm));
        environment.jersey().register(new PostAccept(eventdao,displaydao, dm));
        environment.jersey().register(new PostRegistration(registrationdao));
        environment.jersey().register(new GetCount(eventdao, registrationdao, manneddao, location));
        environment.jersey().register(new PostBreak(registrationdao));
        environment.jersey().register(new GetDisplay(displaydao, dm));
        environment.jersey().register(new PostDisplay(displaydao, dm));
        environment.jersey().register(new PostManned(eventdao, displaydao, manneddao, dm));
    }

}
