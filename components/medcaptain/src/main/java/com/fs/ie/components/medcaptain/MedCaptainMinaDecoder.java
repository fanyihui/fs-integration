package com.fs.ie.components.medcaptain;

import java.util.ArrayList;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MedCaptainMinaDecoder extends CumulativeProtocolDecoder {
	
	private static final Logger logger = LoggerFactory.getLogger(MedCaptainMinaDecoder.class);
	
	private String getSubDump(String dump, int index, int length) {
		int start = index * 3;
		int end = (index + length) * 3;
		return dump.substring(start, Math.min(end, dump.length()));
	}
	
	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		logger.info(in.getHexDump());
		String dump = in.getHexDump();
		logger.info("dump=>" + dump.split(" ").length);
		
		byte[] buf = new byte[in.remaining()];
		in.get(buf);
		
		int code = ByteUtil.getShort(buf, 1, 2) & 0xFFFF;
		int size = ByteUtil.getShort(buf, 3, 2) & 0xFFFF;
		
		logger.info("code=>{} size=>{}", Integer.toHexString(code), size);
		// logger.info("0x0360=>" + (0x0360 == code));
		
		// TODO
		// if (0x0360 == code)
		// return false;
		
		//SocketAddress remoteAddress = session.getRemoteAddress();
		//PatientInfoDTO patientInfoDTO = null;

		MedCaptainMessage medCaptainMessage = new MedCaptainMessage();
		medCaptainMessage.setCommandCode(code);

		switch (code) {
			case 0x0360:
				logger.info("Receive 0x0360 Data {}", Integer.toHexString(code));
				handleMedicationAdminRecord(dump, buf, medCaptainMessage);
				break;
			case 0x8306: // return patient info after retrieve the patient info from device
				logger.info("Receive 0x8360 Data {}", Integer.toHexString(code));
				handlePatientInfo(dump, buf, medCaptainMessage);
				break;
			case 0x0307: // generate patient information from device side
				logger.info("Receive 0x0307 Data {}", Integer.toHexString(code));
				handlePatientInfo(dump, buf, medCaptainMessage);
				break;
			case 0x8308: // update patient information from device side
				logger.info("Receive 0x0307|0x8308 Data {}", Integer.toHexString(code));
				handlePatientInfo(dump, buf, medCaptainMessage);
				//PatientMapper.put(remoteAddress, patientInfoDTO);
				break;
			case 0x8340:
			case 0x8341:
			case 0x0309:
				logger.info("DeptTime:" + ByteUtil.getString(buf, 11, 24));
				logger.info("RoomTime:" + ByteUtil.getString(buf, 35, 24));
				logger.info("BedTime:" + ByteUtil.getString(buf, 59, 24));
				logger.info("Dept:" + ByteUtil.getString(buf, 83, 19));
				logger.info("Room:" + ByteUtil.getString(buf, 102, 11));
				break;
		}

		out.write(medCaptainMessage);

		return true;
	}
	
	protected void handlePatientInfo(String dump, byte[] buf, MedCaptainMessage medCaptainMessage) {
		Patient patientInfoDTO = new Patient();
		
		patientInfoDTO.setInpatientNo(ByteUtil.getString(buf, 11, 19));
		logger.info(getSubDump(dump, 11, 19));
		logger.info("InpatientNo:" + ByteUtil.getString(buf, 11, 19));
		
		patientInfoDTO.setName(ByteUtil.getString(buf, 30, 19));
		logger.info(getSubDump(dump, 30, 19));
		logger.info("Name:" + ByteUtil.getString(buf, 30, 19));
		
		patientInfoDTO.setGender(buf[49]);
		//patientInfoDTO.setGenderType(ResourceUtil.getProperty("gendertype", buf[59]));
		logger.info(getSubDump(dump, 49, 1));
		logger.info("Gender:" + buf[49]);
		
		patientInfoDTO.setAge(buf[50]);
		logger.info(getSubDump(dump, 50, 1));
		logger.info("Age:" + buf[50]);
		
		patientInfoDTO.setHeight(ByteUtil.getFloat(buf, 51, 4));
		logger.info(getSubDump(dump, 51, 4));
		logger.info("Height:" + ByteUtil.getFloat(buf, 51, 4));
		
		patientInfoDTO.setWeight(ByteUtil.getFloat(buf, 55, 4));
		logger.info(getSubDump(dump, 55, 4));
		logger.info("Weight:" + ByteUtil.getFloat(buf, 55, 4));
		
		patientInfoDTO.setPatientType(buf[59]);
		//patientInfoDTO.setPatientType(ResourceUtil.getProperty("patienttype", buf[59]));
		logger.info(getSubDump(dump, 59, 1));
		logger.info("Type:" + buf[59]);
		
		patientInfoDTO.setDepartment(ByteUtil.getString(buf, 60, 19));
		logger.info(getSubDump(dump, 60, 19));
		logger.info("Department:" + ByteUtil.getString(buf, 60, 19));
		
		patientInfoDTO.setRoom(ByteUtil.getString(buf, 79, 11));
		logger.info(getSubDump(dump, 79, 11));
		logger.info("Room:" + ByteUtil.getString(buf, 79, 11));
		
		patientInfoDTO.setBed(ByteUtil.getString(buf, 90, 7));
		logger.info(getSubDump(dump, 90, 7));
		logger.info("Bed:" + ByteUtil.getString(buf, 90, 7));

		medCaptainMessage.setPatient(patientInfoDTO);
	}
	
	protected void handleMedicationAdminRecord(String dump, byte[] buf, MedCaptainMessage medCaptainMessage) {
		//MedCaptainMessage medCaptainMessage = new MedCaptainMessage();
		Device device = new Device();
		Patient patient = new Patient();
		Mar mar = new Mar();

		device.setSn(ByteUtil.getString(buf, 11, 19));
		logger.info(getSubDump(dump, 11, 19));
		logger.info("Sn:" + ByteUtil.getString(buf, 11, 19));

		device.setDeviceType(ResourceUtil.getProperty("devicetype", buf[30]));
		logger.info(getSubDump(dump, 30, 1));
		logger.info("Type:" + buf[30]);

		device.setDeviceModel(ByteUtil.getString(buf, 31, 19));
		logger.info(getSubDump(dump, 31, 19));
		logger.info("Model:" + ByteUtil.getString(buf, 31, 19));

		device.setWorkstationSN(ByteUtil.getString(buf, 50, 19));
		logger.info(getSubDump(dump, 50, 19));
		logger.info("WorkstationSN:" + ByteUtil.getString(buf, 50, 19));

		patient.setDepartment(ByteUtil.getString(buf, 69, 19));
		logger.info(getSubDump(dump, 69, 19));
		logger.info("Department:" + ByteUtil.getString(buf, 69, 19));

		patient.setRoom(ByteUtil.getString(buf, 88, 11));
		logger.info(getSubDump(dump, 88, 11));
		logger.info("Room:" + ByteUtil.getString(buf, 88, 11));
		
		patient.setBed(ByteUtil.getString(buf, 99, 7));
		logger.info(getSubDump(dump, 99, 7));
		logger.info("Bed:" + ByteUtil.getString(buf, 99, 7));


		mar.setStatus(ResourceUtil.getProperty("status", buf[106]));
		logger.info(getSubDump(dump, 106, 1));
		logger.info("Status:" + buf[106]);

		mar.setDrug(ByteUtil.getUTF8String(buf, 107, 25));
		logger.info(getSubDump(dump, 107, 25));
		logger.info("Drug:" + ByteUtil.getUTF8String(buf, 107, 25));

		mar.setInjectionType(ResourceUtil.getProperty("injectiontype", buf[132]));
		logger.info(getSubDump(dump, 132, 1));
		logger.info("InjectionType:" + buf[132]);

		mar.setDosage(ByteUtil.getFloat(buf, 133, 4));
		logger.info(getSubDump(dump, 133, 4));
		logger.info("Dosage:" + ByteUtil.getFloat(buf, 133, 4));

		mar.setSpeed(ByteUtil.getFloat(buf, 137, 4));
		logger.info(getSubDump(dump, 137, 4));
		logger.info("Speed:" + ByteUtil.getFloat(buf, 137, 4));

		mar.setPassTime(ByteUtil.getInt(buf, 141, 4));
		logger.info(getSubDump(dump, 141, 4));
		logger.info("PassTime:" + ByteUtil.getInt(buf, 141, 4));

		mar.setRemainTime(ByteUtil.getInt(buf, 145, 4));
		logger.info(getSubDump(dump, 145, 4));
		logger.info("RemainTime:" + ByteUtil.getInt(buf, 145, 4));

		mar.setInjectedAmount(ByteUtil.getFloat(buf, 149, 4));
		logger.info(getSubDump(dump, 149, 4));
		logger.info("InjectedAmount:" + ByteUtil.getFloat(buf, 149, 4));

		mar.setRemainAmount(ByteUtil.getFloat(buf, 153, 4));
		logger.info(getSubDump(dump, 153, 4));
		logger.info("RemainAmount:" + ByteUtil.getFloat(buf, 153, 4));

		mar.setWarning(getWarning(ByteUtil.getInt(buf, 157, 4)));
		logger.info(getSubDump(dump, 157, 4));
		logger.info("Warning:" + ByteUtil.getInt(buf, 157, 4));
		logger.info("Warning:" + ByteUtil.getBitString(ByteUtil.getInt(buf, 157, 4)));
		logger.info("Warning:" + getWarning(ByteUtil.getInt(buf, 157, 4)));

		medCaptainMessage.setDevice(device);
		medCaptainMessage.setPatient(patient);
		medCaptainMessage.setMar(mar);

		//return medCaptainMessage;
	}
	
	private ArrayList<String> getWarning(int warns) {
		ArrayList<String> warnings = new ArrayList<>();
		long warn = 0x1L;
		long mark = 0xFFFFFFFFL & warns;
		for (int i = 0; i < 32; i++) {
			long w = warn << i;
			if ((w & mark) == w) {
				warnings.add(ResourceUtil.getProperty("warning", i));
			}
		}
		return warnings;
	}
	
}
