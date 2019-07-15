package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * 卡系统加密方法类-copybyother
 */
public class MD5EncodeUtil {

	/**
	 * @param args
	 * 
	 * 
	 */
	static Logger logger = LoggerFactory.getLogger(MD5EncodeUtil.class);

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {

		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * J 转换byte到16进制
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * J 编码
	 * 
	 * @param origin
	 * @return
	 */

	// MessageDigest 为 JDK 提供的加密类
	public static String MD5Encode(String origin) {

		if (origin == null)
			return null;
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
			logger.error(MD5EncodeUtil.class + " --MD5加密异常：" + ex);
		}
		return resultString;
	}
	
	private static final String MD5_KEY = "oct-afw";
	public static String myMD5Encode(String origin){
		
		return MD5Encode(MD5_KEY+origin);
	}

//	public static void main(String[] args) {
//		System.out.println(myMD5Encode("8888176002000000038111111"));
//		String s= myMD5Encode("8888176002000000038111111").substring(8,24);
//		// String a = null;
//		System.out.println(s);
//	}
}
