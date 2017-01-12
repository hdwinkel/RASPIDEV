package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Registration;
import com.ikea.vaexabox.db.Helper;
import com.ikea.vaexabox.db.RegistrationDAO;

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

        // write event in db
        
        registrationDAO.insertInit(r.deviceid, r.name, r.email, Helper.getID(), Helper.get8hTimeStampAsTS(), Helper.getCurrentTimeStampAsTS(), Helper.getCurrentTimeStampAsTS(),1);
		
		return Response.noContent().build();
	}

}