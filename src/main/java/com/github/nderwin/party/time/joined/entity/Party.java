package com.github.nderwin.party.time.joined.entity;

import io.quarkus.hibernate.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;

import static jakarta.persistence.InheritanceType.JOINED;

@Table(schema = "joined", name = "party")
@Entity(name = "JoinedParty")
@Inheritance(strategy = JOINED)
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

}
