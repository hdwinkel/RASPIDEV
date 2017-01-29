package com.ikea.vaexabox.resources;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.DisplayMessages;
import com.ikea.vaexabox.core.Event;
import com.ikea.vaexabox.core.Registration;
import com.ikea.vaexabox.db.DisplayDAO;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.db.MannedDAO;
import com.ikea.vaexabox.db.RegistrationDAO;
import com.ikea.vaexabox.mail.SendTLSMail;
import com.ikea.vaexabox.mail.TLSMail;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostEvent")
@Produces(MediaType.APPLICATION_JSON)
public class PostEvent {

	final EventDAO eventDAO;
	final RegistrationDAO registrationDAO;
	final DisplayDAO displayDAO;
	final MannedDAO mannedDAO;

	final DisplayMessages dm;
	final boolean mustSendMail;
	final TLSMail tlsm;
	final String location;

	public PostEvent(EventDAO eventDAO, RegistrationDAO registrationDAO, DisplayDAO displayDAO, MannedDAO mannedDAO,
			boolean mustSendMail, TLSMail tlsm, String location, DisplayMessages dm) {
		this.eventDAO = eventDAO;
		this.registrationDAO = registrationDAO;
		this.displayDAO = displayDAO;
		this.mannedDAO = mannedDAO;
		this.mustSendMail = mustSendMail;
		this.tlsm = tlsm;
		this.location = location;
		this.dm = dm;
	}

	@POST
	public Response logEvent(Event e) {
		System.out.println("name: " + e.name);
		System.out.println("type: " + e.type);
		System.out.println("count: " + e.count);

		// if office is not manned then proceed normally else stop all activity

		if (mannedDAO.getIsManned(1) != 1) {

			// write event in db
			eventDAO.insert(Helper.getUUID(), e.name, e.type, Helper.getCurrentTimeStampAsTS(), e.count);

			List<Registration> registrations = registrationDAO.findRegistrations(Helper.getCurrentTimeStampAsTS());

			// inform all registered co-worker
			for (Registration reg : registrations) {

				System.out.println(
						"Registration:: deviceid:" + reg.deviceid + " name:" + reg.name + " email:" + reg.email);

				if (mustSendMail) {
					try {
						// System.out.println("Send EMail to "+reg.email);
						SendTLSMail.generateAndSendEmail(tlsm, reg, location, e.count);
					} catch (Exception ex) {
						System.out.println("Exception: " + ex);
					}
				}
			}

			// update display
			displayDAO.updateDisplayMessage(dm.getOnEventDisplay1(), dm.getOnEventDisplay2(),
					Helper.getCurrentTimeStampAsTS());

		}

		// return nothing
		return Response.noContent().build();
	}

}