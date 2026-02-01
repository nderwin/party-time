package com.github.nderwin.party.time.boundary;

import com.github.nderwin.party.time.entity.Person;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRES_NEW;

@Transactional(REQUIRES_NEW)
@Produces(MediaType.APPLICATION_JSON)
@Path("people")
@RequestScoped
public class PersonResource {

    @GET
    public List<Person> list() {
        return Person.listAll();
    }
    
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void create(PersonRequest req) {
        Person p = new Person(req.legalIdentifier, (req.firstName + " " + req.lastName).trim());
        p.persist();
    }

    public record PersonRequest(String legalIdentifier, String firstName, String lastName) {
        
    }
}
