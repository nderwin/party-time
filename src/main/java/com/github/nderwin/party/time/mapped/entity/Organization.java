package com.github.nderwin.party.time.mapped.entity;

import io.quarkus.hibernate.panache.PanacheRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.processing.Find;

@Table(schema = "mapped", name = "organization")
@Entity(name = "MappedOrganization")
public class Organization extends Party {

    protected Organization() {
    }

    public Organization(final String identifier, final String name) {
        super(identifier, name);
    }
    
    public interface Repo extends PanacheRepository<Organization> {
        // Required because the generated metadata class won't have the import statement if this has no methods
        @Find
        Organization findByName(String name);
    }
    
}
