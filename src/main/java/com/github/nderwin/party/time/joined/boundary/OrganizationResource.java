package com.github.nderwin.party.time.joined.boundary;

import com.github.nderwin.party.time.api.boundary.OrganizationRequest;
import com.github.nderwin.party.time.joined.entity.Organization;
import com.github.nderwin.party.time.joined.entity.Organization_;
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
@Path("joined/organizations")
@RequestScoped
public class OrganizationResource {
    
    @GET
    public List<Organization> list() {
        return Organization_.managedBlocking().listAll();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void create(final OrganizationRequest req) {
        final Organization o = new Organization(req.legalIdentifier(), req.name());
        o.persist();
    }
    
}
