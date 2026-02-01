package com.github.nderwin.party.time.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class Name {
    
    @Column(name = "registrationdate", nullable = false)
    private LocalDateTime registrationDate;
    
    @Column(nullable = false)
    private String name;
    
    @Embedded
    private NameDetails details;

    public Name(final LocalDateTime registrationDate, final String name) {
        this.registrationDate = registrationDate;
        this.name = name;
    }
    
    protected Name() {
        
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NameDetails getDetails() {
        return details;
    }

    public void setDetails(NameDetails details) {
        this.details = details;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Name other = (Name) obj;
        return Objects.equals(this.name, other.name);
    }
    
}
