package com.ikea.vaexabox.resources;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Event;
import com.ikea.vaexabox.core.Registration;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.db.RegistrationDAO;
import com.ikea.vaexabox.mail.SendTLSMail;
import com.ikea.vaexabox.mail.TLSMail;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostEvent")
@Produces(MediaType.APPLICATION_JSON)
public class PostEvent {

	final EventDAO eventDAO;
	final RegistrationDAO registrationDAO;
	final boolean mustSendMail;
	final TLSMail tlsm;
	final String location;

	public PostEvent(EventDAO eventDAO, RegistrationDAO registrationDAO, boolean mustSendMail, TLSMail tlsm,
			String location) {
		this.eventDAO = eventDAO;
		this.registrationDAO = registrationDAO;
		this.mustSendMail = mustSendMail;
		this.tlsm = tlsm;
		this.location = location;
	}

	@POST
	public Response logEvent(Event e) {
		System.out.println("name: " + e.name);
		System.out.println("type: " + e.type);
		System.out.println("count: " + e.count);

		// write event in db
		eventDAO.insert(Helper.getUUID(), e.name, e.type, Helper.getCurrentTimeStampAsTS(), e.count);

		List<Registration> registrations = registrationDAO.findRegistrations(Helper.getCurrentTimeStampAsTS());

		for (Registration reg : registrations) {

			System.out.println("Registration:: deviceid:" + reg.deviceid + " name:" + reg.name + " email:" + reg.email);

			if (mustSendMail) {
				try {
					// System.out.println("Send EMail to "+reg.email);
					SendTLSMail.generateAndSendEmail(tlsm, reg, location, e.count);
				} catch (Exception ex) {
					System.out.println("Exception: " + ex);
				}
			}
		}

		// return nothing
		return Response.noContent().build();
	}

}