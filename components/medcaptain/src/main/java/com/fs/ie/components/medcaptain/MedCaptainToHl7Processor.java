package com.fs.ie.components.medcaptain;

import ca.uhn.hl7v2.model.v24.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v24.segment.PV1;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class MedCaptainToHl7Processor implements Processor {
	
	private static final Logger logger = LoggerFactory.getLogger(MedCaptainToHl7Processor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		MedCaptainMessage medCaptainMessage = exchange.getIn().getBody(MedCaptainMessage.class);

		Patient patient = medCaptainMessage.getPatient();
		Device device = medCaptainMessage.getDevice();
		Mar mar = medCaptainMessage.getMar();

		// Start conver the dto to hl7 message
		ORU_R01 message = new ORU_R01();
		// TODO
		message.initQuickstart("ORU", "R01", "P");
		
		MSH msh = message.getMSH();
		msh.getSendingApplication().getNamespaceID().setValue("fsie");
		msh.getSequenceNumber().setValue("123");
		
		PID pid = message.getPATIENT_RESULT().getPATIENT().getPID();
		pid.getPatientIdentifierList(0).getID().setValue(medCaptainMessage.getPatient().getPatientID());
		pid.getPatientName(0).getGivenName().setValue(medCaptainMessage.getPatient().getName());
		pid.getAdministrativeSex().setValue(medCaptainMessage.getPatient().getGender() == 0 ? "M" : "F");
		
		PV1 pv1 = message.getPATIENT_RESULT().getPATIENT().getVISIT().getPV1();
		// pv1.getAdmissionType().setValue("I");
		pv1.getPatientClass().setValue("I");
		pv1.getAssignedPatientLocation().getPointOfCare().setValue(medCaptainMessage.getPatient().getDepartment());
		pv1.getAssignedPatientLocation().getRoom().setValue(medCaptainMessage.getPatient().getRoom());
		pv1.getAssignedPatientLocation().getBed().setValue(medCaptainMessage.getPatient().getBed());
		
		ORU_R01_ORDER_OBSERVATION order_observation = message.getPATIENT_RESULT().getORDER_OBSERVATION();
		HL7HapiUtil.addTX_OBX(message, device.getSn(), "SN", 1);
		HL7HapiUtil.addTX_OBX(message, device.getDeviceType(), "DEVICE_TYPE", 2);
		HL7HapiUtil.addTX_OBX(message, device.getDeviceModel(), "DEVICE_MODEL", 3);
		HL7HapiUtil.addTX_OBX(message, device.getWorkstationSN(), "WORKSTATION_SN", 4);
		HL7HapiUtil.addTX_OBX(message, mar.getStatus(), "STATUS", 5);
		HL7HapiUtil.addTX_OBX(message, mar.getDrug(), "DRUG", 6);
		HL7HapiUtil.addTX_OBX(message, mar.getInjectionType(), "INJECTION_TYPE", 7);
		
		HL7HapiUtil.addCQ_OBX(message, "" + mar.getDosage(), "ml", "DOSAGE", 8);
		HL7HapiUtil.addCQ_OBX(message, "" + mar.getSpeed(), "ml/h", "RATE", 9);
		HL7HapiUtil.addCQ_OBX(message, "" + mar.getPassTime(), "s", "PASS_TIME", 10);
		HL7HapiUtil.addCQ_OBX(message, "" + mar.getRemainTime(), "s", "REMAIN_TIME", 11);
		HL7HapiUtil.addCQ_OBX(message, "" + mar.getInjectedAmount(), "ml", "INJECTED", 12);
		HL7HapiUtil.addCQ_OBX(message, "" + mar.getRemainAmount(), "ml", "REMAINING", 13);
		
		ArrayList<String> warnings = mar.getWarning();
		for (int i = 0; i < warnings.size(); i++) {
			String warn = warnings.get(i);
			HL7HapiUtil.addTX_OBX(message, warn, "WARN", i + 14);
		}
		
		// HapiContext context = new DefaultHapiContext();
		// Parser parser = context.getPipeParser();
		
		// String str = parser.encode(message);
		
		// logger.info("HL7 Message: \n" + str);
		logger.info("HL7 Message: \n" + message);
		
		// context.close();
		
		// exchange.getIn().setBody(str);
		exchange.getIn().setBody(message, ORU_R01.class);
	}
}
