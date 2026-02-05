package com.github.nderwin.party.time.mapped.entity;

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
    
    public interface Repo extends Party.Repo<Organization> {
        @Find
        @Override
        Organization findByName(String name);
    }
    
    public interface StatelessRepo extends Party.StatelessRepo<Organization> {
        @Find
        @Override
        Organization findByName(String name);
    }
    
}
