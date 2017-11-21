package com.fs.ie.components.medcaptain;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtil {
	public static String getIpAddress(){
		try{
			InetAddress address = InetAddress.getLocalHost();
			
			return address.getHostAddress();
		} catch(UnknownHostException uhe){
			uhe.printStackTrace();
			return "localhost";
		}
	}
}
