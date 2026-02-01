package com.github.nderwin.party.time.boundary;

import com.github.nderwin.party.time.entity.Organization;
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
@Path("organizations")
@RequestScoped
public class OrganizationResource {
    
    @GET
    public List<Organization> list() {
        return Organization.listAll();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void create(final OrganizationRequest req) {
        final Organization o = new Organization(req.legalIdentifier, req.name);
        o.persist();
    }
    
    public record OrganizationRequest(String legalIdentifier, String name) {
        
    }
}
