package com.github.nderwin.party.time.mapped.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.processing.Find;

@Table(schema = "mapped", name = "person")
@Entity(name = "MappedPerson")
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
