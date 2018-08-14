package com.fs.ie.model;

import com.fs.ie.model.valueset.GenderCode;

/**
 * Created by faen on 2018/2/5.
 */
public class Patient {
    private String patientId;
    private String surnName;
    private String givenName;
    private GenderCode gender;
    private String birthdate;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSurnName() {
        return surnName;
    }

    public void setSurnName(String surnName) {
        this.surnName = surnName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public GenderCode getGender() {
        return gender;
    }

    public void setGender(GenderCode gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
