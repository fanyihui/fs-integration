package com.fs.ie.mdgw.processor;

import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import com.fs.ie.model.*;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by faen on 2018/2/6.
 */
public class PcdToHL7Processor implements Processor{
    private static final Logger logger = LoggerFactory.getLogger(PcdToHL7Processor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        PcdEvent pcdEvent = exchange.getIn().getBody(PcdEvent.class);

        GenericMessage message = PcdHl7Transfer.buildHl7MessageFromPcd(pcdEvent);

        logger.info("Generating HL7 Message: \n" + message);
        exchange.getIn().setBody(message, Message.class);
    }
}
