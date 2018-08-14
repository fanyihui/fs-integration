package com.fs.ie.model.device.channel;

import com.fs.ie.model.device.MedicalDeviceChannel;

public class InfusionPumpSourceChannel extends MedicalDeviceChannel {
    private String currentDeliveryStatus;
    private String programDeliveryMode;
    private String pumpNotDeliveryReason;
    private String sourceChannelLabel;
    private float rate;
    private float drugDoseRate; //unit MDC_DIM_MILLI_G_PER_HR 4:: (3378) / MDC_DIM_MILLI_G_PER_MIN (4::3346) / MDC_DIM_MICRO_G_PER_HR (4::3379) / MDC_DIM_MICRO_G_PER_MIN (4::3347) / MDC_DIM_X_INTL_UNIT_PER_HR (4::5696)
    private float volumeProgrammed;
    private float currentSegmentVolumeDelivered;
    private float setFluidDeliveryRate; //default unit MDC_DIM_MILLI_L_PER_HR
    private float volumeRemaining; //default unit MDC_DIM_MILLI_L
    private float duration; //default unit MDC_DIM_MIN
    private float volumeInfused; // unit MDC_DIM_MILLI_L
    private float passingTime;
    private float timeRemaining;
    private String drugLabel;

    public float getSetFluidDeliveryRate() {
        return setFluidDeliveryRate;
    }

    public void setSetFluidDeliveryRate(float setFluidDeliveryRate) {
        this.setFluidDeliveryRate = setFluidDeliveryRate;
    }

    public float getVolumeRemaining() {
        return volumeRemaining;
    }

    public void setVolumeRemaining(float volumeRemaining) {
        this.volumeRemaining = volumeRemaining;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public float getDrugDoseRate() {
        return drugDoseRate;
    }

    public void setDrugDoseRate(float drugDoseRate) {
        this.drugDoseRate = drugDoseRate;
    }

    public float getVolumeInfused() {
        return volumeInfused;
    }

    public void setVolumeInfused(float volumeInfused) {
        this.volumeInfused = volumeInfused;
    }

    public String getDrugLabel() {
        return drugLabel;
    }

    public void setDrugLabel(String drugLabel) {
        this.drugLabel = drugLabel;
    }

    public String getCurrentDeliveryStatus() {
        return currentDeliveryStatus;
    }

    public void setCurrentDeliveryStatus(String currentDeliveryStatus) {
        this.currentDeliveryStatus = currentDeliveryStatus;
    }

    public String getProgramDeliveryMode() {
        return programDeliveryMode;
    }

    public void setProgramDeliveryMode(String programDeliveryMode) {
        this.programDeliveryMode = programDeliveryMode;
    }

    public String getPumpNotDeliveryReason() {
        return pumpNotDeliveryReason;
    }

    public void setPumpNotDeliveryReason(String pumpNotDeliveryReason) {
        this.pumpNotDeliveryReason = pumpNotDeliveryReason;
    }

    public String getSourceChannelLabel() {
        return sourceChannelLabel;
    }

    public void setSourceChannelLabel(String sourceChannelLabel) {
        this.sourceChannelLabel = sourceChannelLabel;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getVolumeProgrammed() {
        return volumeProgrammed;
    }

    public void setVolumeProgrammed(float volumeProgrammed) {
        this.volumeProgrammed = volumeProgrammed;
    }

    public float getCurrentSegmentVolumeDelivered() {
        return currentSegmentVolumeDelivered;
    }

    public void setCurrentSegmentVolumeDelivered(float currentSegmentVolumeDelivered) {
        this.currentSegmentVolumeDelivered = currentSegmentVolumeDelivered;
    }

    public float getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(float timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public float getPassingTime() {
        return passingTime;
    }

    public void setPassingTime(float passingTime) {
        this.passingTime = passingTime;
    }
}
