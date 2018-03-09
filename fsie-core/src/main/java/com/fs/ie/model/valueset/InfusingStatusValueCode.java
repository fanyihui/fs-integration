/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.fs.ie.model.valueset;

public enum InfusingStatusValueCode {
    PUMP_STATUS_READY("pump-status-ready"), PUMP_STATUS_INFUSING("pump-status-infusing"), PUMP_STATUS_KVO("pump-status-kvo"),
    PUMP_STATUS_BOLUS("pump-status-bolus"), PUMP_STATUS_ANTIBOLUS("pump-status-antibolus"), PUMP_STATUS_ALARM("pump-status-alarm"),
    PUMP_STATUS_STANDBY("pump-status-standby"), PUMP_STATUS_EXPEL("pump-status-expel");

    private String infusingStatus;

    private InfusingStatusValueCode(String infusingStatus){
        this.infusingStatus = infusingStatus;
    }

    public String getInfusingStatus(){
        return infusingStatus;
    }

    public void setInfusingStatus(String infusingStatus){
        this.infusingStatus = infusingStatus;
    }
}
