package com.github.nderwin.party.time.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(schema = "partay")
@Entity
public class Organization extends Party {

    protected Organization() {
    }

    public Organization(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
