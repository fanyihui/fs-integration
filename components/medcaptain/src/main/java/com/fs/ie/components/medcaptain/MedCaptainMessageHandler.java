package com.fs.ie.components.medcaptain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MedCaptainMessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(MedCaptainMessageHandler.class);

    public static void handleMedicationAdminRecord(byte[] buf, MedCaptainMessage medCaptainMessage) {
        Device device = new Device();
        Patient patient = new Patient();
        Mar mar = new Mar();

        device.setSn(ByteUtil.getString(buf, 11, 19));
        logger.info("Sn:" + ByteUtil.getString(buf, 11, 19));

        device.setDeviceType(ResourceUtil.getProperty("devicetype", buf[30]));
        logger.info("Type:" + buf[30]);

        device.setDeviceModel(ByteUtil.getString(buf, 31, 19));
        logger.info("Model:" + ByteUtil.getString(buf, 31, 19));

        device.setWorkstationSN(ByteUtil.getString(buf, 50, 19));
        logger.info("WorkstationSN:" + ByteUtil.getString(buf, 50, 19));

        patient.setDepartment(ByteUtil.getString(buf, 69, 19));
        logger.info("Department:" + ByteUtil.getString(buf, 69, 19));

        patient.setRoom(ByteUtil.getString(buf, 88, 11));
        logger.info("Room:" + ByteUtil.getString(buf, 88, 11));

        patient.setBed(ByteUtil.getString(buf, 99, 7));
        logger.info("Bed:" + ByteUtil.getString(buf, 99, 7));


        mar.setStatus(ResourceUtil.getProperty("status", buf[106]));
        logger.info("Status:" + buf[106]);

        mar.setDrug(ByteUtil.getUTF8String(buf, 107, 25));
        logger.info("Drug:" + ByteUtil.getUTF8String(buf, 107, 25));

        mar.setInjectionType(ResourceUtil.getProperty("injectiontype", buf[132]));
        logger.info("InjectionType:" + buf[132]);

        mar.setDosage(ByteUtil.getFloat(buf, 133, 4));
        logger.info("Dosage:" + ByteUtil.getFloat(buf, 133, 4));

        mar.setSpeed(ByteUtil.getFloat(buf, 137, 4));
        logger.info("Speed:" + ByteUtil.getFloat(buf, 137, 4));

        mar.setPassTime(ByteUtil.getInt(buf, 141, 4));
        logger.info("PassTime:" + ByteUtil.getInt(buf, 141, 4));

        mar.setRemainTime(ByteUtil.getInt(buf, 145, 4));
        logger.info("RemainTime:" + ByteUtil.getInt(buf, 145, 4));

        mar.setInjectedAmount(ByteUtil.getFloat(buf, 149, 4));
        logger.info("InjectedAmount:" + ByteUtil.getFloat(buf, 149, 4));

        mar.setRemainAmount(ByteUtil.getFloat(buf, 153, 4));
        logger.info("RemainAmount:" + ByteUtil.getFloat(buf, 153, 4));

        mar.setWarning(getWarning(ByteUtil.getInt(buf, 157, 4)));
        logger.info("Warning:" + ByteUtil.getInt(buf, 157, 4));
        logger.info("Warning:" + ByteUtil.getBitString(ByteUtil.getInt(buf, 157, 4)));
        logger.info("Warning:" + getWarning(ByteUtil.getInt(buf, 157, 4)));

        medCaptainMessage.setDevice(device);
        medCaptainMessage.setPatient(patient);
        medCaptainMessage.setMar(mar);
    }

    protected static void handlePatientInfo(byte[] buf, MedCaptainMessage medCaptainMessage) {
        Patient patientInfoDTO = new Patient();

        patientInfoDTO.setPatientID(ByteUtil.getString(buf, 11, 19));
        logger.info("InpatientNo:" + ByteUtil.getString(buf, 11, 19));

        patientInfoDTO.setName(ByteUtil.getString(buf, 30, 19));
        logger.info("Name:" + ByteUtil.getString(buf, 30, 19));

        patientInfoDTO.setGender(buf[49]);
        logger.info("Gender:" + buf[49]);

        patientInfoDTO.setAge(buf[50]);
        logger.info("Age:" + buf[50]);

        patientInfoDTO.setHeight(ByteUtil.getFloat(buf, 51, 4));
        logger.info("Height:" + ByteUtil.getFloat(buf, 51, 4));

        patientInfoDTO.setWeight(ByteUtil.getFloat(buf, 55, 4));
        logger.info("Weight:" + ByteUtil.getFloat(buf, 55, 4));

        patientInfoDTO.setPatientType(buf[59]);
        logger.info("Type:" + buf[59]);

        patientInfoDTO.setDepartment(ByteUtil.getString(buf, 60, 19));
        logger.info("Department:" + ByteUtil.getString(buf, 60, 19));

        patientInfoDTO.setRoom(ByteUtil.getString(buf, 79, 11));
        logger.info("Room:" + ByteUtil.getString(buf, 79, 11));

        patientInfoDTO.setBed(ByteUtil.getString(buf, 90, 7));
        logger.info("Bed:" + ByteUtil.getString(buf, 90, 7));

        medCaptainMessage.setPatient(patientInfoDTO);
    }

    public static ArrayList<String> getWarning(int warns) {
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

    public static void marshal(MedCaptainMessage medCaptainMessage, byte[] body){
        byte[] buf = new byte[256];

        buf[0] = ByteUtil.hexStringToBytes("FA")[0];
        buf[1] = 0x60;
        buf[2] = 0x03;
        byte[] size = ByteUtil.shortToByteArray((short) 150);
        buf[3] = size[1];
        buf[4] = size[0];
        buf[5] = 0;
        buf[6] = 0;
        buf[7] = 0;
        buf[8] = 0;
        buf[9] = 0;
        buf[10] = 5;

        //sn
        byte[] sn = "sn00000000000000001".getBytes();
        for (int i=0;i<sn.length;i++){
            buf[11+i] = sn[i];
        }
        // device type
        buf[30] = 1;

        // device model
        byte[] model = "model00000000000001".getBytes();
        for (int i=0;i<model.length;i++){
            buf[31+i] = model[i];
        }

        // workstation
        byte[] workstation = "ws00000000000000001".getBytes();
        for (int i=0;i<workstation.length;i++){
            buf[50+i] = workstation[i];
        }

        //department
        byte[] department = "dpt0000000000000001".getBytes();
        for (int i=0;i<department.length;i++){
            buf[69+i] = department[i];
        }

        //room
        byte[] room = "room0000001".getBytes();
        for (int i=0;i<room.length;i++){
            buf[88+i] = room[i];
        }

        //bed
        byte[] bed = "bed00001".getBytes();
        for (int i=0;i<bed.length;i++){
            buf[99+i] = bed[i];
        }

        //device status
        buf[106] = 2;

        //drug
        try {
            byte[] drug = "阿莫西林速溶片".getBytes("UTF-8");
            for (int i=0;i<drug.length;i++){
                buf[107+i] = drug[i];
            }
        } catch (UnsupportedEncodingException uee){
            System.out.println(uee.getMessage());
        }

        //injection model
        buf[132] = 0;

        //quantity
        byte[] quantity = ByteUtil.float2byte(500);
        for (int i=0;i<quantity.length;i++){
            buf[133+i] = quantity[i];
        }

        //velocity
        byte[] velocity = ByteUtil.float2byte(250);
        for (int i=0;i<velocity.length;i++){
            buf[137+i] = velocity[i];
        }

        //pasted time
        byte[] pastedTime = ByteUtil.getBytes(3600);
        for (int i=0;i<pastedTime.length;i++){
            buf[141+i] = pastedTime[i];
        }

        //remain time
        byte[] remainTime = ByteUtil.getBytes(3600);
        for (int i=0;i<remainTime.length;i++){
            buf[145+i] = remainTime[i];
        }
        //injected dosage
        byte[] injectedDosage = ByteUtil.float2byte(250);
        for (int i=0;i<injectedDosage.length;i++){
            buf[149+i] = injectedDosage[i];
        }

        //remain dosage
        byte[] remainDosage = ByteUtil.float2byte(250);
        for (int i=0;i<remainDosage.length;i++){
            buf[153+i] = remainDosage[i];
        }

        //warning
        int warn = 0x1;
        int warn0 = warn << 31;
        byte[] warning = ByteUtil.getBytes(warn0);
        for (int i=0;i<warning.length;i++){
            buf[157+i] = warning[i];
        }
    }

}

