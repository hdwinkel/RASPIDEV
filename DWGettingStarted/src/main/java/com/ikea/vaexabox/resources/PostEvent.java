package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Event;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostEvent")
@Produces(MediaType.APPLICATION_JSON)
public class PostEvent {

	final EventDAO eventDAO;
	
	public PostEvent(EventDAO eventDAO) {
		this.eventDAO=eventDAO;
	}
		
    @POST
    public Response logEvent(Event e) {
        System.out.println("name: " + e.name);
        System.out.println("type: " + e.type);
        System.out.println("count: " + e.count);
        
        // write event in db
        
        eventDAO.insert(Helper.getUUID(), e.name, e.type, Helper.getCurrentTimeStampAsTS(), e.count);
        
        // return nothing
        return Response.noContent().build();
    }

}