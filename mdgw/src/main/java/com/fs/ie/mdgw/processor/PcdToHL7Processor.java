package com.fs.ie.mdgw.processor;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v26.datatype.CWE;
import ca.uhn.hl7v2.model.v26.datatype.NM;
import ca.uhn.hl7v2.model.v26.datatype.ST;
import ca.uhn.hl7v2.model.v26.datatype.TX;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.model.v26.segment.MSH;
import ca.uhn.hl7v2.model.v26.segment.OBX;
import ca.uhn.hl7v2.model.v26.segment.PID;
import ca.uhn.hl7v2.model.v26.segment.PV1;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.util.Terser;
import com.fs.ie.model.*;
import com.fs.ie.model.valueset.EventTypeEnum;
import com.fs.ie.model.valueset.ObservationValueTypeCode;
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

        for(int i=0;i<observations.size();i++){
            Observation observation = observations.get(i);

            CodeDefinition codeDefinition = observation.getObservationConceptCode();
            String code = codeDefinition.getCode();
            String codeSystemName = codeDefinition.getCodeSystem().getCodeSystemName();
            String codeDesc = codeDefinition.getCodeDescription();

            String value = observation.getValue();
            String unit = observation.getUnit();

            ObservationValueTypeCode observationValueTypeCode = observation.getValueType();

            ORU_R01_ORDER_OBSERVATION order_observation = oru_r01.getPATIENT_RESULT().getORDER_OBSERVATION();
            OBX obx = order_observation.getOBSERVATION(0).getOBX();
            obx.getSetIDOBX().setValue(""+(i+1));
            obx.getObservationIdentifier().getIdentifier().setValue(code);
            obx.getObservationIdentifier().getText().setValue(codeDesc);
            obx.getObservationIdentifier().getNameOfCodingSystem().setValue(codeSystemName);
            obx.getUnits().getIdentifier().setValue(unit);

            Varies varies = obx.getObservationValue(0);

            switch (observationValueTypeCode){
                case TX:
                    TX tx = new TX(oru_r01);
                    tx.setValue(value);
                    varies.setData(tx);
                    break;
                case NM:
                    NM nm = new NM(oru_r01);
                    nm.setValue(value);
                    varies.setData(nm);
                    break;
                case ST:
                    ST st = new ST(oru_r01);
                    st.setValue(value);
                    varies.setData(st);
                    break;
                case CWE:
                    CWE cwe = new CWE(oru_r01);
                    cwe.getText().setValue(value);
                    varies.setData(cwe);
                    break;
                default:
                    break;
            }

        }

        return oru_r01;
    }

    private Message generateORU_R42(PcdEvent pcdEvent) throws IOException, HL7Exception{
        GenericMessage message = new GenericMessage.V26(new DefaultModelClassFactory());
        message.initQuickstart("ORU", "R42", "P");
        PID pid = (PID)message.get("PID");

        Terser terser = new Terser(message);
        terser.set("MSH-3","FSIE-MDGW");
        terser.set("MSH-4", "FSIE");



        return message;
    }
}
