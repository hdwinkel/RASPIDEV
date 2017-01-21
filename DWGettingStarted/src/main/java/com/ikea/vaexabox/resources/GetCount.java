package com.ikea.vaexabox.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ikea.vaexabox.core.Count;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.db.RegistrationDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/GetCount")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetCount {

	final EventDAO eventDAO;
	final RegistrationDAO registrationDAO;
	final String location;

	public GetCount(EventDAO eventDAO, RegistrationDAO registrationDAO, String location) {
		this.eventDAO = eventDAO;
		this.registrationDAO = registrationDAO;
		this.location = location;
	}

	@GET
	@Path("/{deviceid}")
	public Count getCount(@PathParam("deviceid") String deviceid) {
		int getcount = 0;

		// count independent of a device
		if (deviceid.equals("~")) {
			getcount = eventDAO.getCount();
		} else {

			if (registrationDAO.getCountOfRegistrationsForDeviceIDwithoutBreak(deviceid,
					Helper.getCurrentTimeStampAsTS()) > 0) {
				// count all events for a device outside break-time
  				getcount = eventDAO.getCount();
			}
		}
		Count count = new Count();
		count.count = getcount;
		count.location = location;
		return count;
	}

}