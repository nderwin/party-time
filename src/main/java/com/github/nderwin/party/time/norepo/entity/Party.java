package com.github.nderwin.party.time.norepo.entity;

import io.quarkus.hibernate.panache.PanacheEntity;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
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
    
    public static EntityManager getEntityManager() {
        return CDI.current().select(EntityManager.class).get();
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
    
}
