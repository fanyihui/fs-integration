package com.fs.ie.components.medcaptain;

public class Warning {
	
	public static long warn = 0x1L;
	
	public static long warn0 = warn << 31;
	
	public static long warn1 = warn << 30;
	
	public static long warn2 = warn << 29;
	
	public static long warn3 = warn << 28;
	
	public static long warn4 = warn << 27;
	
	public static long warn5 = warn << 26;
	
	public static long warn6 = warn << 25;
	
	public static long warn7 = warn << 24;
	
	public static long warn8 = warn << 23;
	
	public static long warn9 = warn << 22;
	
	public static long warn10 = warn << 21;
	
	public static long warn11 = warn << 20;
	
	public static long warn12 = warn << 19;
	
	public static long warn13 = warn << 18;
	
	public static long warn14 = warn << 17;
	
	public static long warn15 = warn << 16;
	
	public static long warn16 = warn << 15;
	
	public static long warn17 = warn << 14;
	
	public static long warn18 = warn << 13;
	
	public static long warn19 = warn << 12;
	
	public static long warn20 = warn << 11;
	
	public static long warn21 = warn << 10;
	
	public static long warn22 = warn << 9;
	
	public static long warn23 = warn << 8;
	
	public static long warn24 = warn << 7;
	
	public static long warn25 = warn << 6;
	
	public static long warn26 = warn << 5;
	
	public static long warn27 = warn << 4;
	
	public static long warn28 = warn << 3;
	
	public static long warn29 = warn << 2;
	
	public static long warn30 = warn << 1;
	
	public static long warn31 = warn << 0;
	
	public static long checkWarn(long warn, long warns) {
		long mark = 0xFFFFFFFFL;
		return warn & (mark & warns);
	}
	
}
