package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.DisplayMessages;
import com.ikea.vaexabox.core.Manned;
import com.ikea.vaexabox.db.DisplayDAO;
import com.ikea.vaexabox.db.EventDAO;
import com.ikea.vaexabox.db.MannedDAO;
import com.ikea.vaexabox.tools.Helper;

@Path("/PostManned")
@Produces(MediaType.APPLICATION_JSON)
public class PostManned {

	final EventDAO eventDAO;
	final DisplayDAO displayDAO;
	final MannedDAO mannedDAO;
	final DisplayMessages dm;

	public PostManned(EventDAO eventDAO, DisplayDAO displaydao, MannedDAO manneddao, DisplayMessages dm) {
		this.eventDAO = eventDAO;
		this.displayDAO = displaydao;
		this.mannedDAO = manneddao;
		this.dm = dm;
	}

	@POST
	public Response logManned(Manned m) {
		System.out.println("deviceid: " + m.deviceid);
		System.out.println("ismanned: " + m.ismanned);

		// delete events from db

		if (m.ismanned == 1) {
			eventDAO.delete();
			displayDAO.updateDisplayMessage(dm.getOnMannedDisplay1(), dm.getOnMannedDisplay2(),
					Helper.getCurrentTimeStampAsTS());
			mannedDAO.updateIsManned(1, Helper.getCurrentTimeStampAsTS());
		} else {
			if (mannedDAO.getIsManned(1) == 1) {
				displayDAO.updateDisplayMessage(dm.getInitDisplay1(), dm.getInitDisplay2(),
						Helper.getCurrentTimeStampAsTS());
			}
			mannedDAO.updateIsManned(0, Helper.getCurrentTimeStampAsTS());

		}

		// return nothing
		return Response.noContent().build();
	}

}