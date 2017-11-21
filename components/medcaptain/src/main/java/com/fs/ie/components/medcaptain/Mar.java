package com.fs.ie.components.medcaptain;

import java.util.ArrayList;

public class Mar {
    private String status;

    private String drug;

    private String injectionType;

    private float dosage;

    private float speed;

    private long passTime;

    private long remainTime;

    private float injectedAmount;

    private float remainAmount;

    private ArrayList<String> warning;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getInjectionType() {
        return injectionType;
    }

    public void setInjectionType(String injectionType) {
        this.injectionType = injectionType;
    }

    public float getDosage() {
        return dosage;
    }

    public void setDosage(float dosage) {
        this.dosage = dosage;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public long getPassTime() {
        return passTime;
    }

    public void setPassTime(long passTime) {
        this.passTime = passTime;
    }

    public long getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(long remainTime) {
        this.remainTime = remainTime;
    }

    public float getInjectedAmount() {
        return injectedAmount;
    }

    public void setInjectedAmount(float injectedAmount) {
        this.injectedAmount = injectedAmount;
    }

    public float getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(float remainAmount) {
        this.remainAmount = remainAmount;
    }

    public ArrayList<String> getWarning() {
        return warning;
    }

    public void setWarning(ArrayList<String> warning) {
        this.warning = warning;
    }
}
