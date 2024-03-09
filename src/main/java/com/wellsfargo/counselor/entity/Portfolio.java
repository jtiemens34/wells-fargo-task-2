package com.wellsfargo.counselor.entity;

import  jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue()
    private long portfolioId;

    @Column(nullable = false)
    private Date creationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId")
    private Client client;

    protected Portfolio() { }

    public Portfolio(Date creationDate, Client client)
    {
        this.creationDate = creationDate;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @OneToMany(mappedBy = "portfolio")
    private Collection<Security> security;

    public Collection<Security> getSecurity() {
        return security;
    }

    public void setSecurity(Collection<Security> security) {
        this.security = security;
    }
}
