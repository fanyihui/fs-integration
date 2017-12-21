package com.fs.ie.components.medcaptain;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.spi.DataFormatName;
import org.apache.camel.support.ServiceSupport;
import org.apache.camel.util.ExchangeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;

public class MedCaptainDataFormat extends ServiceSupport implements DataFormat, DataFormatName{
    private static final Logger logger = LoggerFactory.getLogger(MedCaptainDataFormat.class);


    @Override
    public void marshal(Exchange exchange, Object o, OutputStream outputStream) throws Exception {
        MedCaptainMessage medCaptainMessage = ExchangeHelper.convertToMandatoryType(exchange, MedCaptainMessage.class, o);

        int command = medCaptainMessage.getCommandCode();


        //TODO need to be done to marshal a MedCaptainMessage to byte array
        switch (command){
            case 0x0360:
                break;
            case 0x8306:
                break;
            case 0x0307:
                break;
            case 0x8308:
                break;
        }
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream inputStream) throws Exception {
        MedCaptainMessage medCaptainMessage = new MedCaptainMessage();

        byte[] body = ExchangeHelper.convertToMandatoryType(exchange, byte[].class, inputStream);

        int code = ByteUtil.getShort(body, 1, 2) & 0xFFFF;
        int size = ByteUtil.getShort(body, 3, 2) & 0xFFFF;

        logger.info("code=>{} size=>{}", Integer.toHexString(code), size);

        medCaptainMessage.setCommandCode(code);

        switch (code) {
            case 0x0360:
                MedCaptainMessageHandler.handleMedicationAdminRecord(body, medCaptainMessage);
                break;
            case 0x8306: // return patient info after retrieve the patient info from device
                logger.info("Receive 0x8360 Data {}", Integer.toHexString(code));
                MedCaptainMessageHandler.handlePatientInfo(body, medCaptainMessage);
                break;
            case 0x0307: // generate patient information from device side
                logger.info("Receive 0x0307 Data {}", Integer.toHexString(code));
                MedCaptainMessageHandler.handlePatientInfo(body, medCaptainMessage);
                break;
            case 0x8308: // update patient information from device side
                logger.info("Receive 0x0307|0x8308 Data {}", Integer.toHexString(code));
                MedCaptainMessageHandler.handlePatientInfo(body, medCaptainMessage);
                break;
            case 0x8340:
            case 0x8341:
            case 0x0309:
                break;
        }

        exchange.getOut().setHeader("command", code);

        return medCaptainMessage;
    }

    @Override
    public String getDataFormatName() {
        return "medcaptain";
    }

    @Override
    protected void doStart() throws Exception {

    }

    @Override
    protected void doStop() throws Exception {

    }
}
