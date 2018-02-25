/*
VMD may be used to represent either a major functional unit within a device (e.g., a ventilator may have one VMD to contain settings and general operational parameters and
another as an Airway monitor or Airway Gas Analyzer). Additionally, VMDs typically represent units that may be plugged into other devices such as physiological monitors
 */

package com.fs.ie.model.device;

import java.util.ArrayList;

public class VirtualMedicalDevice {
    private String vmdType;
    private String vmdStatus;
    private String vmdManufacturer;
    private String vmdModel;
    private String serialNumber;
    private String softwareRevision;
    private String position;
    private ArrayList<MedicalDeviceChannel> medicalDeviceChannels;

    public String getVmdType() {
        return vmdType;
    }

    public void setVmdType(String vmdType) {
        this.vmdType = vmdType;
    }

    public String getVmdStatus() {
        return vmdStatus;
    }

    public void setVmdStatus(String vmdStatus) {
        this.vmdStatus = vmdStatus;
    }

    public String getVmdManufacturer() {
        return vmdManufacturer;
    }

    public void setVmdManufacturer(String vmdManufacturer) {
        this.vmdManufacturer = vmdManufacturer;
    }

    public String getVmdModel() {
        return vmdModel;
    }

    public void setVmdModel(String vmdModel) {
        this.vmdModel = vmdModel;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSoftwareRevision() {
        return softwareRevision;
    }

    public void setSoftwareRevision(String softwareRevision) {
        this.softwareRevision = softwareRevision;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<MedicalDeviceChannel> getMedicalDeviceChannels() {
        return medicalDeviceChannels;
    }

    public void setMedicalDeviceChannels(ArrayList<MedicalDeviceChannel> medicalDeviceChannels) {
        this.medicalDeviceChannels = medicalDeviceChannels;
    }
}
