package com.fs.ie.model.device.channel;

public class InfusionPumpDeliveryChannel {
    private float totalCurrentRate; // unit MDC_DIM_MILLI_L_PER_HR
    private float totalVolumeInfused; // unit MDC_DIM_MILLI_L
    private String operationalStatus; //“pump-status-infusing” + “pump-status-kvo” + “pump-status-ready” +” pump-status-standby” + “pump-status-paused”
    private String operationalMode; //

    public float getTotalCurrentRate() {
        return totalCurrentRate;
    }

    public void setTotalCurrentRate(float totalCurrentRate) {
        this.totalCurrentRate = totalCurrentRate;
    }

    public float getTotalVolumeInfused() {
        return totalVolumeInfused;
    }

    public void setTotalVolumeInfused(float totalVolumeInfused) {
        this.totalVolumeInfused = totalVolumeInfused;
    }

    public String getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    public String getOperationalMode() {
        return operationalMode;
    }

    public void setOperationalMode(String operationalMode) {
        this.operationalMode = operationalMode;
    }
}
