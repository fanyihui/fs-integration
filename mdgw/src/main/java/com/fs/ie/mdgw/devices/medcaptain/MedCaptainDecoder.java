package com.fs.ie.mdgw.devices.medcaptain;

import com.fs.ie.model.Encounter;
import com.fs.ie.model.Patient;
import com.fs.ie.model.PcdEvent;
import com.fs.ie.model.device.MedicalDeviceSystem;
import com.fs.ie.model.device.VirtualMedicalDevice;
import com.fs.ie.util.ByteUtil;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class MedCaptainDecoder extends CumulativeProtocolDecoder {
    private static final Logger logger = LoggerFactory.getLogger(MedCaptainDecoder.class);

    @Override
    protected boolean doDecode(IoSession ioSession, IoBuffer in, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        logger.info("dump==>"+in.getHexDump());

        byte[] buf = new byte[in.remaining()];
        in.get(buf);

        int code = ByteUtil.getShort(buf, 1, 2) & 0xFFFF;
        int size = ByteUtil.getShort(buf, 3, 2) & 0xFFFF;

        PcdEvent pcdEvent = new PcdEvent();
        Encounter encounter = new Encounter();
        Patient patient = new Patient();
        MedicalDeviceSystem mds = new MedicalDeviceSystem();
        ArrayList<VirtualMedicalDevice> vmds = new ArrayList<>();

        switch (code){
            case 0x0360:
                mds.setSerialNumber(ByteUtil.getString(buf, 11, 19));

                break;
            default:
                break;

        }

        return false;
    }
}
