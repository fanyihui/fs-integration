package com.fs.ie.mdgw.processor;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;

public class PatientADT {
    public String admit(Message message) throws HL7Exception {
        String sql = "insert into med_order (" +
                "PatientName, " +
                "PatientID, " +
                "PatientGender, " +
                "PatientBirth, " +
                "Department, " +
                "Room, " +
                "Bed, " +
                "Weight, " +
                "Height, " +
                "PatientType, IsActive) " +
                "values (";

        Terser terser = new Terser(message);

        String patient_name = terser.get("/PID-5-1")+" "+ terser.get("/PID-5-2");
        String patient_id = terser.get("/PID-3");
        String birthday =  terser.get("/PID-7");
        String gender = terser.get("/PID-8");

        String bed = terser.get("/PV1-3-3");
        String room = terser.get("/PV1-3-2");
        String department = terser.get("/PV1-3-1");
        String patientType = terser.get("/PV1-18");

        String weight = terser.get("/OBX(0)-5");
        String height = terser.get("/OBX(1)-5");

        sql = sql + "'"+patient_name +"', "+
                "'"+patient_id+"', " +
                "'"+gender + "', "+
                "'"+birthday +"', "+
                "'"+department +"', " +
                "'"+room + "', "+
                "'"+bed + "', "+
                weight +", "+
                height + ", "+
                patientType + ", 1)";

        return sql;
    }

    public String discharge(Message message) throws HL7Exception{
        String sql = "update med_order set IsActive=0 where ";

        Terser terser = new Terser(message);

        String patient_name = terser.get("/PID-5-1")+" "+ terser.get("/PID-5-2");
        String patient_id = terser.get("/PID-3");
        String birthday =  terser.get("/PID-7");
        String gender = terser.get("/PID-8");

        String bed = terser.get("/PV1-3-3");
        String room = terser.get("/PV1-3-2");
        String department = terser.get("/PV1-3-1");
        String patientType = terser.get("/PV1-18");

        sql = sql + "PatientName='"+patient_name +"' and Bed='"+bed+"' and PatientID='"+patient_id+"' and IsActive=1";

        return sql;
    }
}
