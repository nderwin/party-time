package com.github.nderwin.party.time.mapped.entity;

import io.quarkus.hibernate.panache.PanacheRepository;
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
    
    public interface Repo extends PanacheRepository<Person> {
        // Required because the generated metadata class won't have the import statement if this has no methods
        @Find
        Person findByName(String name);
    }
    
}
