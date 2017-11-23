package com.fs.ie.components.medcaptain;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.BitSet;

public class ByteUtil {
	
	@Deprecated
	public static float getFloat1(byte[] b) {
		// 4 bytes
		int accum = 0;
		for (int shiftBy = 0; shiftBy < 4; shiftBy++) {
			accum |= (b[shiftBy] & 0xff) << shiftBy * 8;
		}
		return Float.intBitsToFloat(accum);
	}
	
	@Deprecated
	public static long getUInt32(byte[] bytes) throws EOFException {
		long value = bytes[0] & 0xFF;
		value |= (bytes[1] << 8) & 0xFFFF;
		value |= (bytes[2] << 16) & 0xFFFFFF;
		value |= (bytes[3] << 24) & 0xFFFFFFFF;
		
		return value;
	}

	public static long getUint32(long l){
		return l & 0x00000000ffffffff;
	}

	@Deprecated
	public static String byteToBit(byte b) {
		return "" + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1) + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1) + (byte) ((b >> 3) & 0x1)
				+ (byte) ((b >> 2) & 0x1) + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
	}
	
	@Deprecated
	public static BitSet getBitSet(byte b) {
		BitSet bitset = new BitSet(8);
		for (int i = 0; i < 8; i++) {
			if ((b & (1 << i)) > 0) {
				bitset.set(i);
			}
		}
		
		return bitset;
	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}


	public static short getShort(byte... src) {
		ByteBuffer bb = ByteBuffer.allocate(2);
		bb.put(src);
		bb.order(ByteOrder.nativeOrder());
		return bb.getShort(0);
	}

	public static byte[] shortToByteArray(short s) {
		byte[] targets = new byte[2];
		for (int i = 0; i < 2; i++) {
			int offset = (targets.length - 1 - i) * 8;
			targets[i] = (byte) ((s >>> offset) & 0xff);
		}
		return targets;
	}

	public static int getInt(byte... src) {
		return getInt(ByteOrder.nativeOrder(), src);
	}
	
	public static int getInt(ByteOrder order, byte... src) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.put(src);
		bb.order(order);
		return bb.getInt(0);
	}
	
	public static long getLong(byte... src) {
		return getLong(ByteOrder.nativeOrder(), src);
	}
	
	public static long getLong(ByteOrder order, byte... src) {
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.put(src);
		bb.order(order);
		return bb.getLong(0);
	}
	
	public static float getFloat(byte... src) {
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.put(src);
		bb.order(ByteOrder.nativeOrder());
		return bb.getFloat(0);
	}
	
	public static short getShort(byte[] array, int offset, int length) {
		ByteBuffer bb = ByteBuffer.wrap(array, offset, length);
		bb.order(ByteOrder.nativeOrder());
		return bb.getShort();
	}
	
	public static int getInt(byte[] array, int offset, int length) {
		ByteBuffer bb = ByteBuffer.wrap(array, offset, length);
		bb.order(ByteOrder.nativeOrder());
		return bb.getInt();
	}
	
	public static int getInt(ByteOrder order, byte[] array, int offset, int length) {
		ByteBuffer bb = ByteBuffer.wrap(array, offset, length);
		bb.order(order);
		return bb.getInt();
	}
	
	public static long getLong(byte[] array, int offset, int length) {
		ByteBuffer bb = ByteBuffer.wrap(array, offset, length);
		bb.order(ByteOrder.nativeOrder());
		return bb.getLong();
	}
	
	public static float getFloat(byte[] array, int offset, int length) {
		ByteBuffer bb = ByteBuffer.wrap(array, offset, length);
		bb.order(ByteOrder.nativeOrder());
		return bb.getFloat();
	}
	
	public static String getString(byte[] array, int offset, int length) {
		// ByteBuffer bb = ByteBuffer.wrap(array, offset, length);
		// byte[] b = new byte[length];
		// bb.get(b);
		// return new String(b);
		return new String(array, offset, length).trim();
	}
	
	public static String getUTF8String(byte[] array, int offset, int length) {
		return new String(array, offset, length, Charset.forName("UTF-8")).trim();
	}
	
	public static String getBitString(int value) {
		StringBuilder sb = new StringBuilder("00000000000000000000000000000000");
		String vs = Integer.toBinaryString(value);
		sb.replace(sb.length() - vs.length(), sb.length(), vs);
		return sb.toString();
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	public static byte[] float2byte(float f) {

		// 把float转换为byte[]
		int fbit = Float.floatToIntBits(f);

		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (fbit >> (24 - i * 8));
		}

		// 翻转数组
		int len = b.length;
		// 建立一个与源数组元素类型相同的数组
		byte[] dest = new byte[len];
		// 为了防止修改源数组，将源数组拷贝一份副本
		System.arraycopy(b, 0, dest, 0, len);
		byte temp;
		// 将顺位第i个与倒数第i个交换
		for (int i = 0; i < len / 2; ++i) {
			temp = dest[i];
			dest[i] = dest[len - i - 1];
			dest[len - i - 1] = temp;
		}

		return dest;

	}

	public static byte[] getBytes(int data)
	{
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (data & 0xff);
		bytes[1] = (byte) ((data & 0xff00) >> 8);
		bytes[2] = (byte) ((data & 0xff0000) >> 16);
		bytes[3] = (byte) ((data & 0xff000000) >> 24);
		return bytes;
	}
}
