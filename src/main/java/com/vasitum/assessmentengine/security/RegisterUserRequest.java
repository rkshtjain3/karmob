package com.vasitum.assessmentengine.security;



public class RegisterUserRequest {


    private String rpn;
    private String name;
    private String dob;
    private Long assessmentId;

    public String getRpn() {
        return rpn;
    }

    public void setRpn(String rpn) {
        this.rpn = rpn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }
}
