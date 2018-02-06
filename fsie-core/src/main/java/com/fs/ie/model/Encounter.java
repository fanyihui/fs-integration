package com.fs.ie.model;

import java.util.Date;

/**
 * Created by faen on 2018/2/5.
 */
public class Encounter {
    private Patient patient;
    private Date admitDatetime;
    private Date dischargeDatetime;
    private String encounterNum;
    private String department;
    private String roomNo;
    private String bedNo;
    private String encounterStatus;
    private int admitAge;
    private float admitWeight;
    private String weightUnit;
    private float admitHeight;
    private String heightUnit;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getEncounterNum() {
        return encounterNum;
    }

    public void setEncounterNum(String encounterNum) {
        this.encounterNum = encounterNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public int getAdmitAge() {
        return admitAge;
    }

    public void setAdmitAge(int admitAge) {
        this.admitAge = admitAge;
    }

    public float getAdmitWeight() {
        return admitWeight;
    }

    public void setAdmitWeight(float admitWeight) {
        this.admitWeight = admitWeight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public float getAdmitHeight() {
        return admitHeight;
    }

    public void setAdmitHeight(float admitHeight) {
        this.admitHeight = admitHeight;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public Date getAdmitDatetime() {
        return admitDatetime;
    }

    public void setAdmitDatetime(Date admitDatetime) {
        this.admitDatetime = admitDatetime;
    }

    public Date getDischargeDatetime() {
        return dischargeDatetime;
    }

    public void setDischargeDatetime(Date dischargeDatetime) {
        this.dischargeDatetime = dischargeDatetime;
    }

    public String getEncounterStatus() {
        return encounterStatus;
    }

    public void setEncounterStatus(String encounterStatus) {
        this.encounterStatus = encounterStatus;
    }
}
