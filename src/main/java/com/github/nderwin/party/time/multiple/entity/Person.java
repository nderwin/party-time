package com.github.nderwin.party.time.multiple.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.processing.Find;

@Table(schema = "multiple", name = "person")
@Entity(name = "TablePerClassPerson")
public class Person extends Party {

    protected Person() {
    }

    public Person(final String identifier, final String name) {
        super(identifier, name);
    }
    
    public interface Repo extends Party.Repo<Person> {
        @Find
        @Override
        Person findByName(String name);
    }
    
    public interface StatelessRepo extends Party.StatelessRepo<Person> {
        @Find
        @Override
        Person findByName(String name);
    }
    
}
