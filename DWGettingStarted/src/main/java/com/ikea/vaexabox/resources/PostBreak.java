package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Break;
import com.ikea.vaexabox.db.RegistrationDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostBreak")
@Produces(MediaType.APPLICATION_JSON)
public class PostBreak {

	final RegistrationDAO registrationDAO;
	
	public PostBreak(RegistrationDAO registrationDAO) {
		this.registrationDAO=registrationDAO;
	}
		
    @POST
    public Response logBreak(Break r) {
        System.out.println("deviceid: " + r.deviceid);
        System.out.println("minutes: " + r.minutes);
        
        // update break for deviceid
        registrationDAO.updateBreakEndTime(r.deviceid, Helper.getDelayTimeStampAsTS(r.minutes), Helper.getCurrentTimeStampAsTS());
        
        // return nothing
        return Response.noContent().build();
    }

}