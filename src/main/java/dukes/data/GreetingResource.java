package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello-world")
public class GreetingResource {

    @Inject
    private GreetingRepository greetingRepository;

    @GET
    @Produces("text/plain")
    public String hello() {

       return greetingRepository.findAll()
                .map(g -> g.getMessage())
                .findFirst()
                .orElse("Duke not found");
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(@Valid Greeting greeting) {

        Greeting saved = greetingRepository.save(greeting);
        return Response.ok("Created greeting: " + greeting.getId()).build();
    }
}