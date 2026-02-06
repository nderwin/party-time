package com.github.nderwin.party.time.joined.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(schema = "joined", name = "organization")
@Entity(name = "JoinedOrganization")
public class Organization extends Party {

    protected Organization() {
    }

    public Organization(final String identifier, final String name) {
        super(identifier, name);
    }

}
