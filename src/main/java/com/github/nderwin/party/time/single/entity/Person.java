package com.github.nderwin.party.time.single.entity;

import jakarta.persistence.Entity;
import org.hibernate.annotations.processing.Find;

@Entity(name = "SingleTablePerson")
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
