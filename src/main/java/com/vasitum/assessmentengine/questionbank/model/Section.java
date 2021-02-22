package com.vasitum.assessmentengine.questionbank.model;

import com.vasitum.assessmentengine.client.model.Client;
import com.vasitum.assessmentengine.util.JpaTimeAudit;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Section extends JpaTimeAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @OneToOne
    private DifficultyLevel difficultyLevel;

    @ManyToOne
    private Client client;


    @ManyToMany(mappedBy = "sections",fetch = FetchType.LAZY)
    private Set<Assessment> assessments;

    public Set<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(Set<Assessment> assessments) {
        this.assessments = assessments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
