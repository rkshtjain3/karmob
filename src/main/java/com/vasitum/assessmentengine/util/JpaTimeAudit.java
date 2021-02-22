package com.vasitum.assessmentengine.util;

import javax.persistence.*;

@MappedSuperclass
public class JpaTimeAudit {
    private long cTime;
    private long uTime;
    public long getcTime() {
        return cTime;
    }

    public void setcTime(long cTime) {
        this.cTime = cTime;
    }

    public long getuTime() {
        return uTime;
    }

    public void setuTime(long uTime) {
        this.uTime = uTime;
    }

    @PrePersist
    public void prePersist() {
        cTime = System.currentTimeMillis();
        uTime = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        uTime = System.currentTimeMillis();
    }

}
