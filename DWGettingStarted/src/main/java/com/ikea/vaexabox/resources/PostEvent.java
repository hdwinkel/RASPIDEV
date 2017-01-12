package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Event;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.db.Helper;

@Path("/PostEvent")
@Produces(MediaType.APPLICATION_JSON)
public class PostEvent {

	final EventDAO eventDAO;
	
	public PostEvent(EventDAO eventDAO) {
		this.eventDAO=eventDAO;
	}
		
    @POST
    public Response logEvent(Event e) {
        System.out.println("id: " + e.id);
        System.out.println("number: " + e.number);
        System.out.println("type: " + e.type);

        // write event in db
        
        eventDAO.insert(Helper.getID(), e.type, Helper.getCurrentTimeStampAsTS(), e.number);
        
        // return nothing
        return Response.noContent().build();
    }

}