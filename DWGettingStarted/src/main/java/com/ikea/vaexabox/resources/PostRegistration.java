package com.ikea.vaexabox.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ikea.vaexabox.core.Registration;

@Path("/PostRegistration")
@Produces(MediaType.APPLICATION_JSON)
public class PostRegistration {

    @POST
    public Response logRegistration(Registration r) {
        System.out.println("regid: " + r.regid);

        return Response.noContent().build();
    }

}