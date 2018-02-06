package com.fs.ie.mdgw.processor;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.model.v26.segment.PID;
import ca.uhn.hl7v2.model.v26.segment.PV1;
import com.fs.ie.model.*;
import com.fs.ie.model.valueset.EventTypeEnum;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by faen on 2018/2/6.
 */
public class PcdToHL7Processor implements Processor{
    private static final Logger logger = LoggerFactory.getLogger(PcdToHL7Processor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        PcdEvent pcdEvent = exchange.getIn().getBody(PcdEvent.class);
        EventTypeEnum eventType = pcdEvent.getEventType();

        Message message = null;

        switch (eventType){
            case PCDDATA:
                message = generateORU_R01(pcdEvent);
                break;
            case PCD09:
                //messageCode = "ORU";
                //triggerEvent = "R01";
                break;
            case ALERT:
                //messageCode = "ORU";
                //triggerEvent = "R40";
                break;
            case IPEC:
                //messageCode = "ORU";
                //triggerEvent = "R42";
                break;
            case CIO:
                //TODO transfer to RGV^O15
                //messageCode = "RGV";
                //triggerEvent = "015";
                break;
            default:
                break;
        }

        logger.info("Generating HL7 Message: \n" + message);
        exchange.getIn().setBody(message, Message.class);
    }

    private Message generateORU_R01(PcdEvent pcdEvent) throws IOException, HL7Exception{
        if (pcdEvent == null){
            return null;
        }

        Encounter encounter = pcdEvent.getEncounter();
        Patient patient = encounter.getPatient();
        ArrayList<Observation> observations = pcdEvent.getObservations();

        ORU_R01 oru_r01 = new ORU_R01();
        oru_r01.initQuickstart("ORU", "R01", "P");

        PID pid = oru_r01.getPATIENT_RESULT().getPATIENT().getPID();
        pid.getPatientIdentifierList(0).getIDNumber().setValue(patient.getPatientId());
        pid.getPatientName(0).getGivenName().setValue(patient.getGivenName());
        pid.getPatientName(0).getFamilyName().getSurname().setValue(patient.getSurnName());
        pid.getAdministrativeSex().setValue(patient.getGender());
        pid.getDateTimeOfBirth().setValue(patient.getBirthdate());

        PV1 pv1 = oru_r01.getPATIENT_RESULT().getPATIENT().getVISIT().getPV1();
        pv1.getPatientClass().setValue("I");
        pv1.getAssignedPatientLocation().getPointOfCare().setValue(encounter.getDepartment());
        pv1.getAssignedPatientLocation().getRoom().setValue(encounter.getRoomNo());
        pv1.getAssignedPatientLocation().getBed().setValue(encounter.getBedNo());

        //TODO

        return oru_r01;
    }
}
