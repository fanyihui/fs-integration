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
                int status = ByteUtil.getInt(buf[106]);
                String infusingStatus = null;
                switch(status){
                    case 0: //空闲
                        break;
                    case 1: //准备
                        break;
                    case 2: //输注中
                        break;
                    case 3: //KVO
                        break;
                    case 4: //BOLUS
                        break;
                    case 5: //antiBOLUS
                        break;
                    case 6: //排气
                        break;
                    case 7: //报警状态
                        break;
                    case 8: //待机状态
                        break;
                        default:
                            break;

                }
                infusionPumpDeliveryChannel.setInfusingStatus(infusingStatus); //TODO add code here to map the status to MDC code. Map to CWE value type

                InfusionPumpSourceChannel infusionPumpSourceChannel = new InfusionPumpSourceChannel();
                infusionPumpSourceChannel.setDrugLabel(ByteUtil.getString(buf, 107, 25));
                infusionPumpSourceChannel.setProgramDeliveryMode(""+ByteUtil.getInt(buf[132]));
                infusionPumpSourceChannel.setVolumeProgrammed(ByteUtil.getFloat(buf, 133, 4));
                infusionPumpSourceChannel.setDrugDoseRate(ByteUtil.getFloat(buf, 137, 4));
                infusionPumpSourceChannel.setPassingTime(ByteUtil.getInt(buf, 141, 4));
                infusionPumpSourceChannel.setTimeRemaining(ByteUtil.getInt(buf, 145, 4));
                infusionPumpSourceChannel.setVolumeInfused(ByteUtil.getFloat(buf, 149, 4));
                infusionPumpSourceChannel.setVolumeRemaining(ByteUtil.getFloat(buf, 153, 4));

                break;
            default:
                break;

        }

        return false;
    }
}
