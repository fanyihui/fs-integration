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

    //CODE for IPEC
    public static CodeDefinition MDC_EVT_PUMP_DELIV_START = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PUMP_DELIV_START");
    public static CodeDefinition MDC_EVT_PUMP_DELIV_STOP = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PUMP_DELIV_STOP");
    public static CodeDefinition MDC_EVT_PUMP_DELIV_COMP = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PUMP_DELIV_COMP");
    public static CodeDefinition MDC_EVT_COMM_STATUS_CHANGE = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_COMM_STATUS_CHANGE");
    public static CodeDefinition MDC_EVT_PUMP_PROG_CLEARED = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PUMP_PROG_CLEARED");
    public static CodeDefinition MDC_EVT_PUMP_AUTO_PROG_CLEARED = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PUMP_AUTO_PROG_CLEARED");
    public static CodeDefinition MDC_EVT_PATIENT_CHANGE = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PATIENT_CHANGE");
    public static CodeDefinition MDC_EVT_PATIENT_ID_CHANGE = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PATIENT_ID_CHANGE");
    public static CodeDefinition MDC_EVT_PATIENT_PARAMETER_CHANGE = new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PATIENT_PARAMETER_CHANGE");
    public static CodeDefinition MDC_EVT_PUMP_VOL_COUNTERS_CLEARED =new CodeDefinition("", mdcCodeSystem, "MDC_EVT_PUMP_VOL_COUNTERS_CLEARED");
    public static CodeDefinition MDC_EVT_DEVICE_TIME_CHANGED =new CodeDefinition("", mdcCodeSystem, "MDC_EVT_DEVICE_TIME_CHANGED");

    public static CodeDefinition MDC_PUMP_INFUSING_STATUS =new CodeDefinition("184519", mdcCodeSystem, "MDC_PUMP_INFUSING_STATUS");
    public static CodeDefinition MDC_FLOW_FLUID_PUMP_CURRENT =new CodeDefinition("", mdcCodeSystem, "MDC_FLOW_FLUID_PUMP_CURRENT");
    public static CodeDefinition MDC_DEV_PUMP_ACTIVE_SOURCES =new CodeDefinition("", mdcCodeSystem, "MDC_DEV_PUMP_ACTIVE_SOURCES");
    public static CodeDefinition MDC_DEV_PUMP_CURRENT_DELIVERY_STATUS =new CodeDefinition("", mdcCodeSystem, "MDC_DEV_PUMP_CURRENT_DELIVERY_STATUS");
    public static CodeDefinition MDC_DEV_PUMP_PROGRAM_DELIVERY_MODE =new CodeDefinition("", mdcCodeSystem, "MDC_DEV_PUMP_PROGRAM_DELIVERY_MODE");
    public static CodeDefinition MDC_DEV_PUMP_NOT_DELIVERING_REASON =new CodeDefinition("", mdcCodeSystem, "MDC_DEV_PUMP_NOT_DELIVERING_REASON");
    public static CodeDefinition MDC_DEV_PUMP_SOURCE_CHANNEL_LABEL =new CodeDefinition("", mdcCodeSystem, "MDC_DEV_PUMP_SOURCE_CHANNEL_LABEL");
    public static CodeDefinition MDC_FLOW_FLUID_PUMP =new CodeDefinition("", mdcCodeSystem, "MDC_FLOW_FLUID_PUMP");
    public static CodeDefinition MDC_RATE_DOSE =new CodeDefinition("", mdcCodeSystem, "MDC_RATE_DOSE");
    public static CodeDefinition MDC_VOL_FLUID_TBI =new CodeDefinition("", mdcCodeSystem, "MDC_VOL_FLUID_TBI"); //Volume Programmed
    public static CodeDefinition MDC_VOL_FLUID_DELIV_SEGMENT =new CodeDefinition("", mdcCodeSystem, "MDC_VOL_FLUID_DELIV_SEGMENT");
    public static CodeDefinition MDC_VOL_FLUID_DELIV_TOTAL =new CodeDefinition("", mdcCodeSystem, "MDC_VOL_FLUID_DELIV_TOTAL");
    public static CodeDefinition MDC_VOL_FLUID_TBI_REMAIN =new CodeDefinition("", mdcCodeSystem, "MDC_VOL_FLUID_TBI_REMAIN");
    public static CodeDefinition MDC_TIME_PD_REMAIN =new CodeDefinition("", mdcCodeSystem, "MDC_TIME_PD_REMAIN");

    //Code Medical Device System
    public static CodeDefinition MDC_ATTR_SYS_TYPE = new CodeDefinition("", mdcCodeSystem, "MDC_ATTR_SYS_TYPE");
    public static CodeDefinition MDC_ATTR_ID_MODEL = new CodeDefinition("",mdcCodeSystem, "MDC_ATTR_ID_MODEL ");
    public static CodeDefinition MDC_ATTR_SYS_ID = new CodeDefinition("", mdcCodeSystem, "MDC_ATTR_SYS_ID");

    public static CodeDefinition MDC_DEV_PUMP_INFUS_MDS = new CodeDefinition("", mdcCodeSystem, "MDC_DEV_PUMP_INFUS_MDS");
}
