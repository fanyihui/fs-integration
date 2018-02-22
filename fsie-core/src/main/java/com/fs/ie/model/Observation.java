package com.fs.ie.model;

import com.fs.ie.model.valueset.ObservationValueTypeCode;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.Date;

/**
 * Created by faen on 2018/2/5.
 */
public class Observation {
    private ObservationValueTypeCode valueType;
    private CodeDefinition observationConceptCode;
    private String value;
    private Unit unit;
    private Date observationDatetime;

    public ObservationValueTypeCode getValueType() {
        return valueType;
    }

    public void setValueType(ObservationValueTypeCode valueType) {
        this.valueType = valueType;
    }

    public CodeDefinition getObservationConceptCode() {
        return observationConceptCode;
    }

    public void setObservationConceptCode(CodeDefinition observationConceptCode) {
        this.observationConceptCode = observationConceptCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Date getObservationDatetime() {
        return observationDatetime;
    }

    public void setObservationDatetime(Date observationDatetime) {
        this.observationDatetime = observationDatetime;
    }
}
