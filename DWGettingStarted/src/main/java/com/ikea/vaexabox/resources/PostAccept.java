package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Accept;
import com.ikea.vaexabox.core.DisplayMessages;
import com.ikea.vaexabox.db.DisplayDAO;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostAccept")
@Produces(MediaType.APPLICATION_JSON)
public class PostAccept {

	final EventDAO eventDAO;
	final DisplayDAO displayDAO;
	final DisplayMessages dm;
	
	public PostAccept(EventDAO eventDAO, DisplayDAO displaydao, DisplayMessages dm) {
		this.eventDAO=eventDAO;
		this.displayDAO=displaydao;
		this.dm=dm;
	}
		
    @POST
    public Response logAccept(Accept a) {
        System.out.println("deviceid: " + a.deviceid);
        
        // delete events from db
        
        eventDAO.delete();
        displayDAO.updateDisplayMessage(dm.getOnAcceptDisplay1(), dm.getOnAcceptDisplay2(), Helper.getCurrentTimeStampAsTS());
        
        // return nothing
        return Response.noContent().build();
    }

}