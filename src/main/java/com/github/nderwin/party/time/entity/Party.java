package com.github.nderwin.party.time.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.InheritanceType.JOINED;

@Table(schema = "partay", name = "party")
@Entity
@Inheritance(strategy = JOINED)
public abstract class Party extends PanacheEntity {

    @Column(nullable = false)
    private String identifier;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(schema = "partay", name = "registered_names", joinColumns = @JoinColumn(name = "partyid"))
    @OrderColumn(nullable = false)
    @Column(name = "registerednames")
    private List<Name> registeredNames = new ArrayList<>();
    
    @ElementCollection
    @CollectionTable(schema = "partay", name = "alias_names", joinColumns = @JoinColumn(name = "partyid"))
    @Column(name = "aliases")
    private Set<Name> aliases = new HashSet<>();

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
