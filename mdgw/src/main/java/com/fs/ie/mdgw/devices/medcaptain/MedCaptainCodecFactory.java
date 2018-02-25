package com.fs.ie.mdgw.devices.medcaptain;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class MedCaptainCodecFactory implements ProtocolCodecFactory {
    @Override
    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return new MedCaptainEncoder();
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return new MedCaptainDecoder();
    }
}
