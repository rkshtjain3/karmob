package com.vasitum.assessmentengine.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vasitum.assessmentengine.util.JpaTimeAudit;

import javax.persistence.*;

@Entity
public class Client extends JpaTimeAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(20) not null default ''")
    private String fullName;
    @Column(columnDefinition = "varchar(50) not null", unique = true)
    private String email;
    @Column(columnDefinition = "varchar(50) not null")
    private String location;

    @JsonProperty("paid")
    private boolean paid;
    @Column(columnDefinition = "varchar(40) ")
    private String mobile;
    @Column(columnDefinition = "varchar(40) ")
    private String status;
    @Column(columnDefinition = "varchar(40) ",unique = true)
    private String token;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public Client setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Client setLocation(String location) {
        this.location = location;
        return this;
    }

    public boolean isPaid() {
        return paid;
    }

    public Client setPaid(boolean paid) {
        this.paid = paid;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Client setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Client setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Client setToken(String token) {
        this.token = token;
        return this;
    }
}
