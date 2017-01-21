package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Accept;
import com.ikea.vaexabox.core.Display;
import com.ikea.vaexabox.core.DisplayMessages;
import com.ikea.vaexabox.db.DisplayDAO;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostDisplay")
@Produces(MediaType.APPLICATION_JSON)
public class PostDisplay {

	final DisplayDAO displayDAO;
	final DisplayMessages dm;

	public PostDisplay(DisplayDAO displaydao, DisplayMessages dm) {
		this.displayDAO = displaydao;
		this.dm = dm;
	}

	@POST
	public Response logDisplay(Display d) {
		System.out.println("display: " + d.display1 + "/" + d.display2);

		if (d.display1.equalsIgnoreCase("init")) {
			// if JSON is set to 'init' then set init-values in DB (ignore JSON parameter)
			displayDAO.updateDisplayMessage(dm.getInitDisplay1(), dm.getInitDisplay2(),
					Helper.getCurrentTimeStampAsTS());
		} else {
			displayDAO.updateDisplayMessage(d.display1, d.display2, Helper.getCurrentTimeStampAsTS());
		}
		// return nothing
		return Response.noContent().build();
	}

}
