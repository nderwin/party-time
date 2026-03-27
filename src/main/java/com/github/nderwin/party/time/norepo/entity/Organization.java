package com.github.nderwin.party.time.norepo.entity;

import io.quarkus.hibernate.panache.PanacheRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.util.List;
import org.hibernate.annotations.processing.Find;


@Table(schema = "norepo", name = "organization")
@Entity(name = "NoRepoOrganization")
@NamedQueries({
    @NamedQuery(name = "Organization.findAll", query = "SELECT o FROM NoRepoOrganization o")
})
public class Organization extends Party {
    
    protected Organization() {
    }

    public Organization(final String identifier, final String name) {
        super(identifier, name);
    }

    public static List<Organization> listAll() {
        return getEntityManager()
                .createNamedQuery("Organization.findAll", Organization.class)
                .getResultList();
    }
    
    public static List<Organization> findAll() {
        return Organization_.repo().findEmAll();
    }
    
    public static List<Organization> getAll() {
        return Organization_.repo().getSession()
                .createNamedQuery("Organization.findAll", Organization.class)
                .getResultList();
    }
    
    public interface Repo extends PanacheRepository<Organization> {
        @Find
        List<Organization> findEmAll();
    }

}
