package com.vasitum.assessmentengine.questionbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vasitum.assessmentengine.client.model.Client;
import com.vasitum.assessmentengine.util.JpaTimeAudit;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Assessment extends JpaTimeAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String bannerImg;
    private int totalQuestion;
    //in minutes
    private int duration;
    @JsonProperty("active")
    private boolean active;
    private String proctor;
    private String instruction;
    @OneToOne
    private DifficultyLevel difficultyLevel;
    @ManyToOne
    private Client client;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Section> sections;

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getProctor() {
        return proctor;
    }

    public void setProctor(String proctor) {
        this.proctor = proctor;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
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
