package com.fs.ie.model.device.channel;

import com.fs.ie.model.valueset.InfusingStatusValueCode;

public class InfusionPumpDeliveryChannel {
    private float totalCurrentRate; // unit MDC_DIM_MILLI_L_PER_HR
    private float totalVolumeInfused; // unit MDC_DIM_MILLI_L
    private InfusingStatusValueCode infusingStatus; //“pump-status-infusing” + “pump-status-kvo” + “pump-status-ready” +” pump-status-standby” + “pump-status-paused”
    private String operationalMode; //
    private String currentPumpFluidFlow;
    private String pumpActiveSources;

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

    public InfusingStatusValueCode getInfusingStatus() {
        return infusingStatus;
    }

    public void setInfusingStatus(InfusingStatusValueCode infusingStatus) {
        this.infusingStatus = infusingStatus;
    }

    public String getOperationalMode() {
        return operationalMode;
    }

    public void setOperationalMode(String operationalMode) {
        this.operationalMode = operationalMode;
    }
}
