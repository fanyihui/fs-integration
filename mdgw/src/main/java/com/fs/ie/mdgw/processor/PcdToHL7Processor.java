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

        Encounter encounter = pcdEvent.getEncounter();
        Patient patient = encounter.getPatient();
        ArrayList<Observation> observations = pcdEvent.getObservations();

        GenericMessage message = new GenericMessage.V26(new DefaultModelClassFactory());
        String messageCode = "ORU";
        String messageTriggerEvent = "R01";
        String processingId = "P";
        String profileOid = "";


        switch (eventType){
            case PCDDATA:
                profileOid = "1.3.6.1.4.1.19376.1.6.1.1.1";
                break;
            case PCD09:
                profileOid = "1.3.6.1.4.1.19376.1.6.1.9.1";
                break;
            case ALERT:
                messageCode = "ORU";
                messageTriggerEvent = "R40";
                profileOid = "1.3.6.1.4.1.19376.1.6.1.4.1";
                break;
            case IPEC:
                messageCode = "ORU";
                messageTriggerEvent = "R42";
                profileOid = "1.3.6.1.4.1.19376.1.6.4.10";
                break;
            case CIO:
                messageCode = "RGV";
                messageTriggerEvent = "015";
                profileOid = "1.3.6.1.4.1.19376.1.6.1.3.1";
                break;
            default:
                break;
        }

        message.initQuickstart(messageCode,messageTriggerEvent,processingId);
        message.addNonstandardSegment("PID");
        message.addNonstandardSegment("PV1");
        Terser terser = new Terser(message);

        //Set MSH
        terser.set("MSH-3","pcd-gateway");
        terser.set("MSH-4", "fs");
        terser.set("MSH-21-3", profileOid);
        terser.set("MSH-21-4", "PCD");

        //Set PID
        terser.set("PID-3(0)-1", patient.getPatientId());
        terser.set("PID-5(0)-1", patient.getSurnName());
        terser.set("PID-5(0)-2", patient.getGivenName());
        terser.set("PID-7", patient.getBirthdate());
        terser.set("PID-8", patient.getGender());

        //Set PV1
        terser.set("PV1-2", "I");
        terser.set("PV1-3-1", encounter.getDepartment());
        terser.set("PV1-3-2", encounter.getRoomNo());
        terser.set("PV1-3-3", encounter.getBedNo());

        //Set OBX
        for (int i = 0; i < observations.size(); i++) {
            message.addNonstandardSegment("OBX");
            Observation observation = observations.get(i);
            ObservationValueTypeCode valueTypeCode = observation.getValueType();
            CodeDefinition codeDefinition = observation.getObservationConceptCode();
            String code = codeDefinition.getCode();
            String codeSystemName = codeDefinition.getCodeSystem().getCodeSystemName();
            String codeDesc = codeDefinition.getCodeDescription();
            String value = observation.getValue();
            Unit unit = observation.getUnit();

            terser.set("OBX("+i+")-1", ""+(i+1));
            terser.set("OBX("+i+")-2", valueTypeCode.getValueTypeCode());
            terser.set("OBX("+i+")-3-1", code);
            terser.set("OBX("+i+")-3-2", codeDesc);
            terser.set("OBX("+i+")-3-3", codeSystemName);

            switch (valueTypeCode){
                case NM:
                    terser.set("OBX("+i+")-5", value);
                    terser.set("OBX("+i+")-6-1", unit.getUnitId());
                    terser.set("OBX("+i+")-6-2", unit.getUnitText());
                    terser.set("OBX("+i+")-6-3", unit.getUnitSystemName());
                    terser.set("OBX("+i+")-6-4", unit.getUccmUnit().getUnitId());
                    terser.set("OBX("+i+")-6-5", unit.getUccmUnit().getUnitText());
                    terser.set("OBX("+i+")-6-6", unit.getUccmUnit().getUnitSystemName());
                    break;
                case ST:
                    terser.set("OBX("+i+")-5", value);
                    break;
                case TX:
                    terser.set("OBX("+i+")-5", value);
                    break;
                case CWE:
                    //TODO for coded value
                    terser.set("OBX("+i+")-5", value);
                    break;
                default:
                    break;
            }


        }

        logger.info("Generating HL7 Message: \n" + message);
        exchange.getIn().setBody(message, Message.class);
    }
}
