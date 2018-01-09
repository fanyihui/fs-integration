package com.fs.ie.components.medcaptain;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;

public class PatientInfoEnrichStrategy implements AggregationStrategy {
    private static final Logger logger = LoggerFactory.getLogger(PatientInfoEnrichStrategy.class);


    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange sourceExchange) {
        if (sourceExchange == null || sourceExchange.getIn() == null){
            return oldExchange;
        }

        MedCaptainMessage medCaptainMessage = oldExchange.getIn().getBody(MedCaptainMessage.class);

        Message message = sourceExchange.getIn();
        ArrayList<Map> sourceResult = sourceExchange.getIn().getBody(ArrayList.class);

        if(sourceResult == null || sourceResult.size()<=0)
            return oldExchange;


        Map<String, String> source = sourceResult.get(0);

        String patname = source.get("PatientName");
        String patid = source.get("PatientID");
        String birthday = source.get("PatientBirth");
        String gender = source.get("PatientGender");


        medCaptainMessage.getPatient().setName(patname);
        medCaptainMessage.getPatient().setPatientID(patid);
        medCaptainMessage.getPatient().setGender(gender.equals("F") ? 0 : 1);
        medCaptainMessage.getPatient().setBirthday(birthday);

        oldExchange.getIn().setBody(medCaptainMessage);
        return oldExchange;
    }
}
