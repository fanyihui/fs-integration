package com.fs.ie.components.medcaptain;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient {
	public static void main(String args[]){
		byte[] buf = new byte[256];
		DatagramSocket socket = null;
		try{
			socket = new DatagramSocket();
			
		} catch (SocketException se){
			se.printStackTrace();
		}
		
		InetAddress address = InetAddress.getLoopbackAddress();
		System.out.println(address);
		
		buf[0] = ByteUtil.hexStringToBytes("FA")[0];
		//byte[] code = ByteUtil.hexStringToBytes("0360");
		buf[1] = 0x60;
		buf[2] = 0x03;
		byte[] size = ByteUtil.shortToByteArray((short) 150);
		buf[3] = size[0];
		buf[4] = size[1];
		buf[5] = 0;
		buf[6] = 0;
		buf[7] = 0;
		buf[8] = 0;
		buf[9] = 0;
		buf[10] = 5;

		//sn
		byte[] sn = "sn00000000000000001".getBytes();
		for (int i=0;i<sn.length;i++){
			buf[11+i] = sn[i];
		}
		// device type
		buf[30] = 1;

		// device model
		byte[] model = "model00000000000001".getBytes();
		for (int i=0;i<model.length;i++){
			buf[31+i] = model[i];
		}

		// workstation
		byte[] workstation = "ws00000000000000001".getBytes();
		for (int i=0;i<workstation.length;i++){
			buf[50+i] = workstation[i];
		}

		//department
		byte[] department = "dpt0000000000000001".getBytes();
		for (int i=0;i<department.length;i++){
			buf[69+i] = department[i];
		}

		//room
		byte[] room = "room0000001".getBytes();
		for (int i=0;i<room.length;i++){
			buf[88+i] = room[i];
		}

		//bed
		byte[] bed = "bed00001".getBytes();
		for (int i=0;i<bed.length;i++){
			buf[99+i] = bed[i];
		}

		//device status
		buf[106] = 2;

		//drug
		try {
			byte[] drug = "阿莫西林速溶片".getBytes("UTF-8");
			for (int i=0;i<drug.length;i++){
				buf[107+i] = drug[i];
			}
		} catch (UnsupportedEncodingException uee){
			System.out.println(uee.getMessage());
		}

		//injection model
		buf[132] = 0;

		//quantity
		byte[] quantity = ByteUtil.float2byte(500);
		for (int i=0;i<quantity.length;i++){
			buf[133+i] = quantity[i];
		}

		//velocity
		byte[] velocity = ByteUtil.float2byte(250);
		for (int i=0;i<velocity.length;i++){
			buf[137+i] = velocity[i];
		}

		//pasted time
		byte[] pastedTime = ByteUtil.getBytes(3600);
		for (int i=0;i<pastedTime.length;i++){
			buf[141+i] = pastedTime[i];
		}

		//remain time
		byte[] remainTime = ByteUtil.getBytes(3600);
		for (int i=0;i<remainTime.length;i++){
			buf[145+i] = remainTime[i];
		}
		//injected dosage
		byte[] injectedDosage = ByteUtil.float2byte(250);
		for (int i=0;i<injectedDosage.length;i++){
			buf[149+i] = injectedDosage[i];
		}

		//remain dosage
		byte[] remainDosage = ByteUtil.float2byte(250);
		for (int i=0;i<remainDosage.length;i++){
			buf[153+i] = remainDosage[i];
		}

		//warning
		int warn = 0x1;
		int warn0 = warn << 31;
		byte[] warning = ByteUtil.getBytes(warn0);
		for (int i=0;i<warning.length;i++){
			buf[157+i] = warning[i];
		}

		DatagramPacket packet = new DatagramPacket(buf,  buf.length, address, 26800);
		try{
			socket.send(packet);
			socket.close();
			System.out.println(buf);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
