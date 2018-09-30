package com.fs.ie.components.chship.processors;

import com.fs.ie.components.chship.model.HIPAction;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.apache.log4j.Logger;

public class RequestValidator implements Processor{
    private static final Logger LOGGER = Logger
            .getLogger(RequestValidator.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        MessageContentsList messageContentsList = exchange.getIn().getBody(MessageContentsList.class);
        String action = messageContentsList.get(0).toString();
        String message = messageContentsList.get(1).toString();

        try
        {
            HIPAction hipAction = HIPAction.valueOf(action);

            switch(hipAction){
                case PatientRegistryAddRequest:
                    break;
                case PatientRegistryReviseRequest:
                    break;
                default:
                    break;
            }
        } catch (Exception e){
            throw e;
        }



    }
}
