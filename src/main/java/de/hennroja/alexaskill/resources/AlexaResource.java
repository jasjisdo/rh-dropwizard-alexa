package de.hennroja.alexaskill.resources;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import com.codahale.metrics.annotation.Timed;
import de.hennroja.alexaskill.AlexaSpeechlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


/**
 * Created by hennroja on 20/03/16.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class AlexaResource extends SpeechletServlet {

    private final static Logger logger = LoggerFactory.getLogger(AlexaResource.class);

    @Context
    HttpServletRequest servletRequest;

    @Context
    HttpServletResponse servletResponse;

    public AlexaResource(AlexaSpeechlet speechlet) {
        setSpeechlet(speechlet);
    }

    @GET
    @Timed
    public Response getCall(String name) {
        logger.debug("GET call");

        return Response.ok("hello world!").build();
    }

    @POST
    public void postWrapper() throws ServletException, IOException {
        super.doPost(servletRequest, servletResponse);
    }


}