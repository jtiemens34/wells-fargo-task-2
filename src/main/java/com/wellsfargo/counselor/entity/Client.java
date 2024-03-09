package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Client {
    @Id
    @GeneratedValue()
    private long clientId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advisorId", nullable = false)
    private Advisor advisor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    protected Client() { }

    public Client(Advisor advisor,
                  String firstName,
                  String lastName,
                  String address,
                  String phone,
                  String email)
    {
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @OneToMany(mappedBy = "portfolio")
    private Collection<Portfolio> portfolios;

    public Collection<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Collection<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public long getClientId() {
        return clientId;
    }
}
