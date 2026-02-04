package com.github.nderwin.party.time.single.entity;

import jakarta.persistence.Entity;

@Entity(name = "SingleTableOrganization")
public class Organization extends Party {

    protected Organization() {
    }

    public Organization(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
