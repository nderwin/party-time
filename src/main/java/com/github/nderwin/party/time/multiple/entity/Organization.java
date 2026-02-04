package com.github.nderwin.party.time.multiple.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(schema = "multiple", name = "organization")
@Entity(name = "TablePerClassOrganization")
public class Organization extends Party {

    protected Organization() {
    }

    public Organization(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
