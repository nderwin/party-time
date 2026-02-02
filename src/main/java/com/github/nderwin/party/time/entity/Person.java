package com.github.nderwin.party.time.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(schema = "partay", name = "person")
@Entity
public class Person extends Party {

    protected Person() {
    }

    public Person(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
