package com.fs.ie.mdgw.devices.medcaptain;

import com.fs.ie.model.Encounter;
import com.fs.ie.model.Patient;
import com.fs.ie.model.PcdEvent;
import com.fs.ie.model.device.MedicalDeviceSystem;
import com.fs.ie.model.device.VirtualMedicalDevice;
import com.fs.ie.model.device.channel.InfusionPumpDeliveryChannel;
import com.fs.ie.model.device.channel.InfusionPumpSourceChannel;
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
                int type = ByteUtil.getInt(buf[30]);
                String mdsType = (type == 0) ? "":((type == 1)?"":""); //TODO add code here to map the device type to MDC type
                mds.setSystemType(mdsType);
                mds.setSystemModel(ByteUtil.getString(buf, 31, 19));

                encounter.setDepartment(ByteUtil.getString(buf, 69, 19));
                encounter.setRoomNo(ByteUtil.getString(buf, 88, 11));
                encounter.setBedNo(ByteUtil.getString(buf, 99, 7));

                InfusionPumpDeliveryChannel infusionPumpDeliveryChannel = new InfusionPumpDeliveryChannel();
                infusionPumpDeliveryChannel.setOperationalStatus(""+ByteUtil.getInt(buf[106])); //TODO add code here to map the status to MDC code. Map to CWE value type

                InfusionPumpSourceChannel infusionPumpSourceChannel = new InfusionPumpSourceChannel();
                infusionPumpSourceChannel.setDrugLabel(ByteUtil.getString(buf, 107, 25));

                break;
            default:
                break;

        }

        return false;
    }
}
