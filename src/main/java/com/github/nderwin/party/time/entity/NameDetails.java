package com.github.nderwin.party.time.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class NameDetails {

    @Column
    private String familyName;
    
    @Column
    private String prefix;

    @Column
    private String suffix;

    public NameDetails(final String familyName, final String prefix, final String suffix) {
        this.familyName = familyName;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    protected NameDetails() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(final String suffix) {
        this.suffix = suffix;
    }
    
}
