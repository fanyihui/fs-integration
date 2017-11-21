package com.fs.ie.components.medcaptain;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v23.datatype.TX;
import ca.uhn.hl7v2.model.v24.datatype.CQ;
import ca.uhn.hl7v2.model.v24.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.segment.OBX;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HL7HapiUtil {
	private static final Logger logger = LoggerFactory.getLogger(HL7HapiUtil.class);
	
	public static void addCQ_OBX(ORU_R01 message, String value, String unit, String identifier, int seqNum){
		ORU_R01_ORDER_OBSERVATION order_observation = message.getPATIENT_RESULT().getORDER_OBSERVATION();
		OBX obx = order_observation.getOBSERVATION(0).getOBX();
		
		try {
			obx.getSetIDOBX().setValue("" + seqNum);
			obx.getObservationIdentifier().getIdentifier().setValue(identifier);
			obx.getValueType().setValue("CQ");
			CQ cq = new CQ(message);
			cq.getQuantity().setValue(value);
			cq.getUnits().getText().setValue(unit);
			Varies v = obx.getObservationValue(0);
			v.setData(cq);
		} catch (DataTypeException dte){
			logger.error(dte.getMessage(), dte);
		}
	}
	
	public static void addTX_OBX(ORU_R01 message, String value, String identifier, int seqNum){
		ORU_R01_ORDER_OBSERVATION order_observation = message.getPATIENT_RESULT().getORDER_OBSERVATION();
		OBX obx = order_observation.getOBSERVATION(0).getOBX();
		
		try {
			obx.getSetIDOBX().setValue("" + seqNum);
			obx.getObservationIdentifier().getIdentifier().setValue(identifier);
			obx.getValueType().setValue("TX");
			TX tx = new TX(message);
			tx.setValue(value);
			Varies v = obx.getObservationValue(0);
			v.setData(tx);
		} catch (DataTypeException dte){
			logger.error(dte.getMessage(), dte);
		}
	}
}
