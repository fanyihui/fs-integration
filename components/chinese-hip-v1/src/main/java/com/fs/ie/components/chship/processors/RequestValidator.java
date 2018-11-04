package com.fs.ie.components.chship.processors;

import com.fs.ie.components.chship.exception.NotCompatibleWithSchemaException;
import com.fs.ie.components.chship.exception.StandardNotSupportException;
import com.fs.ie.components.chship.model.HIPAction;
import com.sun.org.apache.bcel.internal.generic.LOOKUPSWITCH;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class RequestValidator implements Processor{
    private static final Logger LOGGER = Logger
            .getLogger(RequestValidator.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        MessageContentsList messageContentsList = exchange.getIn().getBody(MessageContentsList.class);
        String action = messageContentsList.get(0).toString();
        String message = messageContentsList.get(1).toString();

        HIPAction hipAction = HIPAction.valueOf(action);

        if (hipAction == null){
            throw new StandardNotSupportException(action);
        }

        try {
            Document document = DocumentHelper.parseText(message);
        } catch (DocumentException de){
            LOGGER.info(de);
            throw de;
        }

        String schemaFile = null;

        switch(hipAction){
            case PatientRegistryAddRequest:
                schemaFile = "multicacheschemas/PRPA_IN201311UV02.xsd";
                break;
            case PatientRegistryReviseRequest:
                break;
            default:
                break;
        }

        try
        {
            StreamSource streamSource = new StreamSource(Thread.currentThread().getContextClassLoader().getResourceAsStream(schemaFile));

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(streamSource);
            Validator validator = schema.newValidator();
            validator.validate(streamSource);
        } catch (SAXException e){
            LOGGER.error(e);
            throw new NotCompatibleWithSchemaException(e.getMessage());
        }


    }
}
