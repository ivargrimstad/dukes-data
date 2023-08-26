package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/greetings")
public class GreetingResource {

    @Inject
    private GreetingRepository greetingRepository;

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String findOne(@PathParam("name") String name) {

       return greetingRepository.findByNameIgnoreCase(name)
               .map(Greeting::getMessage)
               .orElse(name + " not found");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Greeting> findAll() {

        return greetingRepository.findAll()
                .toList();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Greeting greeting) {

        Greeting saved = greetingRepository.save(greeting);
        return Response.ok("Created greeting: " + greeting.getId()).build();
    }
}