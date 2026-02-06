package com.github.nderwin.party.time.mapped.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(schema = "mapped", name = "person")
@Entity(name = "MappedPerson")
public class Person extends Party {

    protected Person() {
    }

    public Person(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
