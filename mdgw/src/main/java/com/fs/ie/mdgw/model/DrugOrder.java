package com.fs.ie.mdgw.model;

/**
 * Created by faen on 2018/2/5.
 */
public class DrugOrder extends Order{
    private int minAmount;
    private int maxAmount;
    private int amountUnit;
    private String dosage;
    private int rate;
    private int rateUnit;
    private int strengthVolume; //main ingredient
    private String strengthUnit;
    private int diluentVolume;
    private String diluentVolumeUnit;
    private int duration;
    private int durationUnit; // hour, minute, second
    private String route; //hl70162  ^IV^HL70162
    private String admitDevice; //hl70164 ^IVP^HL70164 forLVP pumps, ^PCA^HL70164 for PCA pumps, or ^SYR^HL70164 for Syringe pump


    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(int amountUnit) {
        this.amountUnit = amountUnit;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRateUnit() {
        return rateUnit;
    }

    public void setRateUnit(int rateUnit) {
        this.rateUnit = rateUnit;
    }

    public int getStrengthVolume() {
        return strengthVolume;
    }

    public void setStrengthVolume(int strengthVolume) {
        this.strengthVolume = strengthVolume;
    }

    public String getStrengthUnit() {
        return strengthUnit;
    }

    public void setStrengthUnit(String strengthUnit) {
        this.strengthUnit = strengthUnit;
    }

    public int getDiluentVolume() {
        return diluentVolume;
    }

    public void setDiluentVolume(int diluentVolume) {
        this.diluentVolume = diluentVolume;
    }

    public String getDiluentVolumeUnit() {
        return diluentVolumeUnit;
    }

    public void setDiluentVolumeUnit(String diluentVolumeUnit) {
        this.diluentVolumeUnit = diluentVolumeUnit;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(int durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getAdmitDevice() {
        return admitDevice;
    }

    public void setAdmitDevice(String admitDevice) {
        this.admitDevice = admitDevice;
    }
}
