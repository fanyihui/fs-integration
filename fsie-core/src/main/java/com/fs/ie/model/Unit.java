package com.fs.ie.model;

public class Unit {
    private String unitId;
    private String unitText;
    private String unitSystemName;
    private Unit alternativeUnit;

    public Unit(String unitId, String unitText, String unitSystemName){
        this.unitId = unitId;
        this.unitText = unitText;
        this.unitSystemName = unitSystemName;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitText() {
        return unitText;
    }

    public void setUnitText(String unitText) {
        this.unitText = unitText;
    }

    public String getUnitSystemName() {
        return unitSystemName;
    }

    public void setUnitSystemName(String unitSystemName) {
        this.unitSystemName = unitSystemName;
    }

    public Unit getAlternativeUnit() {
        return alternativeUnit;
    }

    public void setAlternativeUnit(Unit alternativeUnit) {
        this.alternativeUnit = alternativeUnit;
    }
}
