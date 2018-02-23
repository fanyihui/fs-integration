package com.fs.ie.mdgw.processor;

import ca.uhn.hl7v2.model.GenericMessage;
import com.fs.ie.model.*;
import com.fs.ie.model.valueset.EventTypeEnum;
import com.fs.ie.model.valueset.MDCCode;
import com.fs.ie.model.valueset.ObservationValueTypeCode;

import java.util.ArrayList;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        PcdEvent pcdEvent = new PcdEvent();
        Patient patient = new Patient();
        patient.setPatientId("pid000001");
        patient.setGivenName("Smith");
        patient.setSurnName("John");
        patient.setBirthdate("1980-02-03");
        patient.setGender("F");

        Encounter encounter = new Encounter();
        encounter.setPatient(patient);
        encounter.setAdmitAge(38);
        encounter.setDepartment("internal medicine");
        encounter.setRoomNo("room01");
        encounter.setBedNo("bed01");

        pcdEvent.setEventType(EventTypeEnum.PCD01);
        pcdEvent.setEventDateTime(new Date());
        pcdEvent.setEncounter(encounter);

        ArrayList<Observation> observations = new ArrayList<>();
        for (int i = 0; i<5; i++) {
            Observation observation = new Observation();
            observation.setObservationConceptCode(MDCCode.MDC_RATE_DOSE);
            observation.setObservationDatetime(new Date());
            observation.setValueType(ObservationValueTypeCode.NM);
            observation.setValue("500");
            Unit uccmUnit = new Unit("ml", "ml", "UCUM");
            Unit unit = new Unit("263762", "MDC_DIM_MILLI_L", "MDC");
            unit.setAlternativeUnit(uccmUnit);
            observation.setUnit(unit);

            observations.add(observation);
        }

        pcdEvent.setObservations(observations);

        GenericMessage message = PcdHl7Transfer.buildHl7MessageFromPcd(pcdEvent);

        System.out.println(message.printStructure());
    }
}
