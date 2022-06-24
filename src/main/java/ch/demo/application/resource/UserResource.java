package ch.demo.application.resource;

import ch.demo.application.adapter.UserFacade;
import ch.demo.domain.model.UserDTO;
import ch.demo.infrastructure.entity.User;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public class UserResource {

    @Inject
    UserFacade userFacade;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<User> getById(@PathParam("id") final Long id) {
        return userFacade.getById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @ReactiveTransactional
    public Uni<User> get(@RequestBody final UserDTO userDTO) {
        return userFacade.save(userDTO);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<User>> get() {
        return userFacade.get();
    }
}