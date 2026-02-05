package com.github.nderwin.party.time.single.boundary;

import com.github.nderwin.party.time.api.boundary.PersonRequest;
import com.github.nderwin.party.time.single.entity.Person;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
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
@Path("single/people")
@RequestScoped
public class PersonResource {

    @Inject
    Person.Repo repo;
    
    @GET
    public List<Person> list() {
        return repo.listAll();
    }
    
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void create(PersonRequest req) {
        Person p = new Person(req.legalIdentifier(), (req.firstName() + " " + req.lastName()).trim());
        p.persist();
    }

}
