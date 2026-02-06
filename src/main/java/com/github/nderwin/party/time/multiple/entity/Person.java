package com.github.nderwin.party.time.multiple.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(schema = "multiple", name = "person")
@Entity(name = "TablePerClassPerson")
public class Person extends Party {

    protected Person() {
    }

    public Person(final String identifier, final String name) {
        super(identifier, name);
    }
    
}
