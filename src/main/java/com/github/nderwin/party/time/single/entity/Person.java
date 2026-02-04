package com.github.nderwin.party.time.single.entity;

import jakarta.persistence.Entity;

@Entity(name = "SingleTablePerson")
public class Person extends Party {

    protected Person() {
    }

    public Person(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
