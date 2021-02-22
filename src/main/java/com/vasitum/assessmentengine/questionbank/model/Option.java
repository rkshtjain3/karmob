package com.vasitum.assessmentengine.questionbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.xml.internal.ws.developer.Serialization;

import javax.persistence.*;

@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    @JsonProperty("isCorrect")
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
