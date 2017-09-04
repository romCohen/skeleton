package controllers;

import io.dropwizard.jersey.sessions.Session;

import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/netid")
public class NetIDController {

    @GET
    public String getNetID() {
        return "rc783";
    }
}
