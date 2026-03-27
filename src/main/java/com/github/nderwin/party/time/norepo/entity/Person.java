package com.github.nderwin.party.time.norepo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.util.List;


@Table(schema = "norepo", name = "person")
@Entity(name = "NoRepoPerson")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM NoRepoPerson p")
})
public class Person extends Party {
    
    protected Person() {
    }

    public Person(final String identifier, final String name) {
        super(identifier, name);
    }
    
    public static List<Person> listAll() {
        return getEntityManager()
                .createNamedQuery("Person.findAll", Person.class)
                .getResultList();
    }

}
