package com.fs.ie.model.device;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class MedicalDeviceSystem {
    private String systemType;
    private String systemModel;
    private String systemId;
    private String softId; // Locally ID, for example hospital inventory number, non-manufacturer
    private String serialNumber;
    private String softwareVersion;
    private String bedLabel; //identifying the bed to which the device has been assigned
    private String dateTime; //current device datetime
    private String powerStatus; // “onMains”, “onBattery”, “chargingFull”, “chargingTrickle”, “chargingOff”
    private String batteryLevel; //percentage of battery capacity remaining
    private String remainingBatteryTime;
    private ArrayList<VirtualMedicalDevice> virtualMedicalDevices;

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getSystemModel() {
        return systemModel;
    }

    public void setSystemModel(String systemModel) {
        this.systemModel = systemModel;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSoftId() {
        return softId;
    }

    public void setSoftId(String softId) {
        this.softId = softId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getBedLabel() {
        return bedLabel;
    }

    public void setBedLabel(String bedLabel) {
        this.bedLabel = bedLabel;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus;
    }

    public String getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getRemainingBatteryTime() {
        return remainingBatteryTime;
    }

    public void setRemainingBatteryTime(String remainingBatteryTime) {
        this.remainingBatteryTime = remainingBatteryTime;
    }

    public ArrayList<VirtualMedicalDevice> getVirtualMedicalDevices() {
        return virtualMedicalDevices;
    }

    public void setVirtualMedicalDevices(ArrayList<VirtualMedicalDevice> virtualMedicalDevices) {
        this.virtualMedicalDevices = virtualMedicalDevices;
    }
}
