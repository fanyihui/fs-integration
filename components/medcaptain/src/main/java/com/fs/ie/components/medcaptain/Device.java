package com.fs.ie.components.medcaptain;

public class Device {
    private String sn;

    private String deviceType;

    private String deviceModel;

    private String workstationSN;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getWorkstationSN() {
        return workstationSN;
    }

    public void setWorkstationSN(String workstationSN) {
        this.workstationSN = workstationSN;
    }
}
