package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Registration;
import com.ikea.vaexabox.db.RegistrationDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostRegistration")
@Produces(MediaType.APPLICATION_JSON)
public class PostRegistration {

	final RegistrationDAO registrationDAO;

	public PostRegistration(RegistrationDAO registrationDAO) {
		this.registrationDAO = registrationDAO;
	}

	@POST
	public Response logRegistration(Registration r) {
		System.out.println("deviceid: " + r.deviceid);
		System.out.println("name: " + r.name);
		System.out.println("email: " + r.email);

		if (registrationDAO.getCountOfRegistrationsForDeviceID(r.deviceid)>0) {
			// update registration in db
			registrationDAO.updateRegistration(r.deviceid, r.name, r.email, Helper.getUUID(), Helper.getCurrentTimeStampAsTS(), Helper.getCurrentTimeStampAsTS(), Helper.getCurrentTimeStampAsTS());
		} else {
			// write init registration in db
        	registrationDAO.initRegistration(r.deviceid, r.name, r.email, Helper.getUUID(), Helper.getCurrentTimeStampAsTS(), Helper.getCurrentTimeStampAsTS(), Helper.getCurrentTimeStampAsTS());
		}
        
		return Response.noContent().build();
	}

}