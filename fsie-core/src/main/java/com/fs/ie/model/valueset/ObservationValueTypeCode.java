package com.fs.ie.model.valueset;

public enum ObservationValueTypeCode {
    TX("TX"), NM("NM"), ST("ST"), CWE("CWE"), CNE("CNE");

    private String valueTypeCode;

    private ObservationValueTypeCode(String datatype){
        this.valueTypeCode = datatype;
    }

    public String getValueTypeCode() {
        return valueTypeCode;
    }

    public void setValueTypeCode(String valueTypeCode) {
        this.valueTypeCode = valueTypeCode;
    }
}
