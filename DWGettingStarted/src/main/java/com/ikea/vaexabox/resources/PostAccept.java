package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Accept;
import com.ikea.vaexabox.core.Event;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostAccept")
@Produces(MediaType.APPLICATION_JSON)
public class PostAccept {

	final EventDAO eventDAO;
	
	public PostAccept(EventDAO eventDAO) {
		this.eventDAO=eventDAO;
	}
		
    @POST
    public Response logAccept(Accept a) {
        System.out.println("deviceid: " + a.deviceid);
        
        // delete events from db
        
        eventDAO.delete();
        
        // return nothing
        return Response.noContent().build();
    }

}