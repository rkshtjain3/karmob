package com.vasitum.assessmentengine.userprofile.model;

import com.vasitum.assessmentengine.client.model.Client;
import com.vasitum.assessmentengine.util.JpaTimeAudit;

import javax.persistence.*;

@Entity
public class UserProfile extends JpaTimeAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(20) not null default ''")
    private String fullName;
    @Column(columnDefinition = "integer not null ",unique = true)
    private long rpn;
    @Column(columnDefinition = "varchar(20) not null default ''")
    private String dob;
    @Column(columnDefinition = "varchar(10) not null default ''")
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Long getId() {
        return id;
    }

    public UserProfile setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfile setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public long getRpn() {
        return rpn;
    }

    public UserProfile setRpn(long rpn) {
        this.rpn = rpn;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public UserProfile setDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserProfile setRole(String role) {
        this.role = role;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public UserProfile setClient(Client client) {
        this.client = client;
        return this;
    }
}
