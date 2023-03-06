package it.coopservice;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    @Inject
    MessageProducer producer;

    @POST
    public Response send(Message message) {
        producer.sendMessageToKafka(message);
        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }
}
