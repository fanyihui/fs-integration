package com.fs.ie.components.chship.processors;

import com.fs.ie.components.chship.exception.StandardNotSupportException;
import com.fs.ie.components.chship.model.HIPAction;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

public class RequestHandler implements Processor{
    private static final Logger LOGGER = Logger
            .getLogger(RequestHandler.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        MessageContentsList messageContentsList = exchange.getIn().getBody(MessageContentsList.class);
        String action = messageContentsList.get(0).toString();
        String message = messageContentsList.get(1).toString();

        String rootElement = null;

        try {
            Document document = DocumentHelper.parseText(message);
            rootElement = document.getRootElement().getName();
            //TODO add code here to handle the mapping between action and root element
        } catch (DocumentException de){
            LOGGER.error(de);
            throw de;
        }

        HIPAction hipAction = HIPAction.valueOf(action);

        if (hipAction == null) {
            throw new StandardNotSupportException(action);
        }

        exchange.getIn().setHeader("ACTION", action);
        exchange.getIn().setBody(message);

        /*
        String schemaFile = null;

        switch(hipAction){
            case PatientRegistryAddRequest:
                schemaFile = "schemas/multicacheschemas/PRPA_IN202311UV02.xsd";
                break;
            case PatientRegistryReviseRequest:
                schemaFile = "schemas/multicacheschemas/PRPA_IN202312UV02.xsd";
                break;
            default:
                break;
        }

        try
        {
            StreamSource streamSource = new StreamSource(this.getClass().getClassLoader().getResourceAsStream(schemaFile));

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schemaFactory.setResourceResolver(new ClasspathResourceResolver());
            Schema schema = schemaFactory.newSchema(streamSource);
            Validator validator = schema.newValidator();
            validator.validate(streamSource);
        } catch (SAXException e){
            LOGGER.error(e);
            throw new NotCompatibleWithSchemaException(e.getMessage());
        }

        //TODO validate incoming message one by one and build a response message accordi


        */
    }
}
