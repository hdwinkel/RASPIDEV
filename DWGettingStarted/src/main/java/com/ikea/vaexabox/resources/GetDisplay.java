package com.ikea.vaexabox.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ikea.vaexabox.core.Count;
import com.ikea.vaexabox.core.Display;
import com.ikea.vaexabox.core.DisplayMessages;
import com.ikea.vaexabox.db.DisplayDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/GetDisplay")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetDisplay {

	final DisplayDAO displayDAO;
	final DisplayMessages dm;

	public GetDisplay(DisplayDAO displayDAO, DisplayMessages dm) {
		this.displayDAO = displayDAO;
		this.dm = dm;
	}

	@GET
	public Display getDisplay() {

		Display display = new Display();
		// as default use init-values
		display.display1 = dm.getInitDisplay1();
		display.display2 = dm.getInitDisplay2();

		List<Display> displayMessages = displayDAO.getDiplayMessages();
		
		if (displayMessages.size()>0 ) {
			display.display1=displayMessages.get(0).display1;
			display.display2=displayMessages.get(0).display2;
		}	
		
		return display;
	}

}