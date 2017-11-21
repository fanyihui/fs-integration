package com.fs.ie.components.medcaptain;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.spi.DataFormatName;
import org.apache.camel.support.ServiceSupport;

import java.io.InputStream;
import java.io.OutputStream;

public class MedCaptainDataFormat extends ServiceSupport implements DataFormat, DataFormatName{
    @Override
    public void marshal(Exchange exchange, Object o, OutputStream outputStream) throws Exception {

    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream inputStream) throws Exception {
        return null;
    }

    @Override
    public String getDataFormatName() {
        return null;
    }

    @Override
    protected void doStart() throws Exception {

    }

    @Override
    protected void doStop() throws Exception {

    }
}
