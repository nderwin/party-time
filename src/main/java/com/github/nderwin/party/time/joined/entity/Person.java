package com.github.nderwin.party.time.joined.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(schema = "joined", name = "person")
@Entity(name = "JoinedPerson")
public class Person extends Party {

    protected Person() {
    }

    public Person(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
