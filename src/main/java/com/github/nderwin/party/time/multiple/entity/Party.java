package com.github.nderwin.party.time.multiple.entity;

import io.quarkus.hibernate.panache.PanacheEntity;
import io.quarkus.hibernate.panache.managed.blocking.PanacheManagedBlockingRepository;
import io.quarkus.hibernate.panache.stateless.blocking.PanacheStatelessBlockingRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import org.hibernate.annotations.processing.Find;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Table(schema = "multiple", name = "party")
@Entity(name = "TablePerClassParty")
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Party extends PanacheEntity {

    @Column(nullable = false)
    private String identifier;

    @Column(nullable = false)
    private String name;

    public Party(final String identifier, final String name) {
        this.identifier = identifier;
        this.name = name;
    }

    protected Party() {
        
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    
    protected interface Repo<T extends Party> extends PanacheManagedBlockingRepository<T> {
        @Find
        T findByName(String name);
    }
    
    protected interface StatelessRepo<T extends Party> extends PanacheStatelessBlockingRepository<T> {
        @Find
        T findByName(String name);
    }

}
