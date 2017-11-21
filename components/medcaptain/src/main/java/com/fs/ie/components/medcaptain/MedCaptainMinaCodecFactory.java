package com.fs.ie.components.medcaptain;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class MedCaptainMinaCodecFactory implements ProtocolCodecFactory {
	
	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return new MedCaptainMinaDecoder();
	}
	
	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return new ProtocolEncoder() {
			
			public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
				System.out.println("encode message***********" + message);
				// IoBuffer buf = toIoBuffer(message);
				// buf.flip();
				// out.write(buf);
			}
			
			public void dispose(IoSession session) throws Exception {
				// do nothing
			}
		};
	}
	
}
