package com.fs.ie.mdgw.model;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by faen on 2018/2/5.
 */
public class PcdEvent {
    private EventTypeEnum eventType;
    private Date eventDateTime;
    private Encounter encounter;
    private ArrayList<Observation> observations;

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public ArrayList<Observation> getObservations() {
        return observations;
    }

    public void setObservations(ArrayList<Observation> observations) {
        this.observations = observations;
    }
}
