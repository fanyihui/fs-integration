package com.fs.ie.model;

import com.fs.ie.model.valueset.ObservationValueTypeCode;

import java.util.Date;

/**
 * Created by faen on 2018/2/5.
 */
public class Observation {
    private ObservationValueTypeCode valueType;
    private String observationConceptCode;
    private String value;
    private String unit;
    private Date observationDatetime;

    public ObservationValueTypeCode getValueType() {
        return valueType;
    }

    public void setValueType(ObservationValueTypeCode valueType) {
        this.valueType = valueType;
    }

    public String getObservationConceptCode() {
        return observationConceptCode;
    }

    public void setObservationConceptCode(String observationConceptCode) {
        this.observationConceptCode = observationConceptCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getObservationDatetime() {
        return observationDatetime;
    }

    public void setObservationDatetime(Date observationDatetime) {
        this.observationDatetime = observationDatetime;
    }
}
