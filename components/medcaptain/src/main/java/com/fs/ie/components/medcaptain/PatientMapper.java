package com.fs.ie.components.medcaptain;

import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientMapper {
	
	private final static Logger logger = LoggerFactory.getLogger(PatientMapper.class);
	
	private static Map<String, PatientInfoDTO> mapper = new ConcurrentHashMap<String, PatientInfoDTO>();
	
	public static PatientInfoDTO put(String address, PatientInfoDTO info) {
		return mapper.put(address, info);
	}
	
	public static PatientInfoDTO put(SocketAddress address, PatientInfoDTO info) {
		return mapper.put(address.toString(), info);
	}
	
	public static PatientInfoDTO remove(String address) {
		return mapper.remove(address);
	}
	
	public static PatientInfoDTO remove(SocketAddress address) {
		return mapper.remove(address.toString());
	}
	
	public static PatientInfoDTO get(String address) {
		return mapper.get(address);
	}
	
	public static PatientInfoDTO get(SocketAddress address) {
		return mapper.get(address.toString());
	}
	
	public static void require(SocketAddress address) {
		logger.info("UDPClient::UDPClient");
		logger.info("Created a datagram connector");
		IoConnector connector = new NioDatagramConnector();
		
		logger.info("Setting the handler");
		connector.setHandler(new IoHandlerAdapter() {
			
			@Override
			public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
				cause.printStackTrace();
			}
			
			@Override
			public void messageReceived(IoSession session, Object message) throws Exception {
				logger.info("Session recv...");
			}
			
			@Override
			public void messageSent(IoSession session, Object message) throws Exception {
				logger.info("Message sent...");
			}
			
			@Override
			public void sessionClosed(IoSession session) throws Exception {
				logger.info("Session closed...");
			}
			
			@Override
			public void sessionCreated(IoSession session) throws Exception {
				logger.info("Session created...");
			}
			
			@Override
			public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
				logger.info("Session idle...");
			}
			
			@Override
			public void sessionOpened(IoSession session) throws Exception {
				logger.info("Session opened...");
			}
		});
		
		logger.info("About to connect to the server...");
		ConnectFuture connFuture = connector.connect(address);
		
		logger.info("About to wait.");
		connFuture.awaitUninterruptibly();
		
		logger.info("Adding a future listener.");
		connFuture.addListener(new IoFutureListener<ConnectFuture>() {
			
			public void operationComplete(ConnectFuture future) {
				if (future.isConnected()) {
					logger.info("...connected");
					IoSession session = future.getSession();
					byte[] header = get0x0306();
					IoBuffer buffer = IoBuffer.allocate(header.length);
					buffer.put(header);
					buffer.flip();
					session.write(buffer);
				} else {
					logger.error("Not connected...exiting");
				}
			}
		});
	}
	
	private static byte[] get0x0306() {
		byte[] req = new byte[11];
		req[0] = -6; // 0xFA
		req[1] = 6; // 0x06
		req[2] = 3; // 0x03
		req[3] = 0;
		req[4] = 0;
		req[5] = 0;
		req[6] = 0;
		req[7] = 0;
		req[8] = 0;
		req[9] = 0;
		req[10] = 3; // checksum
		return req;
	}
	
}
