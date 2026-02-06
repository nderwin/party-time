package com.github.nderwin.party.time.mapped.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(schema = "mapped", name = "organization")
@Entity(name = "MappedOrganization")
public class Organization extends Party {

    protected Organization() {
    }

    public Organization(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
