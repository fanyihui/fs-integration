package com.fs.ie.model.device.channel;

import com.fs.ie.model.device.MedicalDeviceChannel;

public class InfusionPumpSourceChannel extends MedicalDeviceChannel {
    private float setFluidDeliveryRate; //default unit MDC_DIM_MILLI_L_PER_HR
    private float remainingVTBI; //default unit MDC_DIM_MILLI_L
    private float duration; //default unit MDC_DIM_MIN
    private float drugDoseRate; //unit MDC_DIM_MILLI_G_PER_HR 4:: (3378) / MDC_DIM_MILLI_G_PER_MIN (4::3346) / MDC_DIM_MICRO_G_PER_HR (4::3379) / MDC_DIM_MICRO_G_PER_MIN (4::3347) / MDC_DIM_X_INTL_UNIT_PER_HR (4::5696)
    private float volumeInfused; // unit MDC_DIM_MILLI_L
    private String drugLable;

    public float getSetFluidDeliveryRate() {
        return setFluidDeliveryRate;
    }

    public void setSetFluidDeliveryRate(float setFluidDeliveryRate) {
        this.setFluidDeliveryRate = setFluidDeliveryRate;
    }

    public float getRemainingVTBI() {
        return remainingVTBI;
    }

    public void setRemainingVTBI(float remainingVTBI) {
        this.remainingVTBI = remainingVTBI;
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

    public String getDrugLable() {
        return drugLable;
    }

    public void setDrugLable(String drugLable) {
        this.drugLable = drugLable;
    }
}
