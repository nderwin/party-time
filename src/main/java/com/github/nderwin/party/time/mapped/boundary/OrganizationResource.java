package com.github.nderwin.party.time.mapped.boundary;

import com.github.nderwin.party.time.api.boundary.OrganizationRequest;
import com.github.nderwin.party.time.mapped.entity.Organization;
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
@Path("mapped/organizations")
@RequestScoped
public class OrganizationResource {
    
    @Inject
    Organization.Repo repo;
    
    @GET
    public List<Organization> list() {
        return repo.listAll();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void create(final OrganizationRequest req) {
        final Organization o = new Organization(req.legalIdentifier(), req.name());
        o.persist();
    }
    
}
