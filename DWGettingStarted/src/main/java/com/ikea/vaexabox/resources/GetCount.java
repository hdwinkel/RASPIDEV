package com.ikea.vaexabox.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ikea.vaexabox.core.Count;
import com.ikea.vaexabox.db.EventDAO;

@Path("/GetCount")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetCount {

	final EventDAO eventDAO;
	final String location;
	
	public GetCount(EventDAO eventDAO, String location) {
		this.eventDAO=eventDAO;
		this.location=location;
	}
	
	@GET
	@Path("/{deviceid}")
    public Count getCount(@PathParam("deviceid") String deviceid)  {
        int getcount = eventDAO.getCount();
        Count count = new Count();
        count.count=getcount;
        count.location=location;
        return count;
    }
	

}