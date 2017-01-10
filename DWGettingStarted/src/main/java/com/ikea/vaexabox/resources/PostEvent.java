package com.ikea.vaexabox.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Event;

@Path("/PostEvent")
@Produces(MediaType.APPLICATION_JSON)
public class PostEvent {

    @POST
    public Response logEvent(Event e) {
        System.out.println("id: " + e.id);
        System.out.println("number: " + e.number);
        System.out.println("type: " + e.type);

        return Response.noContent().build();
    }

}