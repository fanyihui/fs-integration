package com.fs.ie.model.valueset;

import com.fs.ie.model.CodeDefinition;
import com.fs.ie.model.CodeSystem;

public class MDCCode {
    public static CodeSystem mdcCodeSystem = new CodeSystem("", "MDC", "MDC Terms");

    //IDC Implantable Cardiac Device System
    //Implantable Pulse Generator
    public static CodeDefinition MDC_IDC_DEV_MODEL = new CodeDefinition("", mdcCodeSystem, "MDC_IDC_DEV_MODEL");
    public static CodeDefinition MDC_IDC_DEV_SERIAL = new CodeDefinition("", mdcCodeSystem, "MDC_IDC_DEV_SERIAL");

    public static CodeDefinition MDC_ECG_CARD_BEAT_RATE = new CodeDefinition("16770", mdcCodeSystem, "MDC_ECG_CARD_BEAT_RATE");
    public static CodeDefinition MDC_PUMP_INFUSING_STATUS = new CodeDefinition("184519", mdcCodeSystem, "MDC_PUMP_INFUSING_STATUS");


}
