package com.vasitum.assessmentengine.userprofile.payload;


public class UserProfilePayload {
    private String name;
    private Long rpn;
    private String dob;
    private String role;
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRpn() {
        return rpn;
    }

    public void setRpn(Long rpn) {
        this.rpn = rpn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
