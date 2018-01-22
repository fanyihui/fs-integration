package com.fs.ie.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by faen on 2018/1/22.
 */
public class FailureProcessor implements Processor{
    @Override
    public void process(Exchange exchange) throws Exception {
        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT,
                Exception.class);
        String failure = "The message failed because " + e.getMessage();
        exchange.getIn().setHeader("FailureMessage", failure);
    }
}
