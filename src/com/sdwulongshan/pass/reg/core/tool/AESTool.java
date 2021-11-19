/*
 * Copyright (c) 2021 Mango.
pass-reg-core is licensed under Mulan PubL v2.
You can use this software according to the terms and conditions of the Mulan PubL v2.
You may obtain a copy of Mulan PubL v2 at:
         http://license.coscl.org.cn/MulanPubL-2.0
THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
See the Mulan PubL v2 for more details.
 */
package com.sdwulongshan.pass.reg.core.tool;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import com.sdwulongshan.pass.reg.core.ex.AESException;
import com.sdwulongshan.pass.reg.core.ex.BaseException;
/**
 * 此类集合了AES相关方法
 * @author Mango.
 * @author xiaoYu.
 * @author qianQian.
 * @since JDK10 
 * @see javax.crypto.spec.SecretKeySpec
 * @version 1.0.2
 * 
 *
 */
public final class AESTool {

	/**
	 * 此方法用于将byte数组转为Hex字符串
	 * @param bytes　要转换的数组
	 * @return 转换后的字符串
	 * @author Mango.
	 * @version 1.0.1
	 * @since JDK_1.8.0_271
	 */
	public static String byte2hex(byte[] bytes) {
		String string = "";
		int n = 0;
		while (n < bytes.length) {
			String string2 = Integer.toHexString(bytes[n] & 0xFF);
			string = string2.length() == 1 ? new StringBuffer().append(new StringBuffer().append(string).append("0").toString()).append(string2).toString() : new StringBuffer().append(string).append(string2).toString();
			++n;
		}
		return string.toUpperCase();
	}
	
	/**
	 * 此方法用于判断所传参数是否为空<br>
	 * 参数为要判断的字符串<br>
	 * 如果传入的参数为空串或为null将会返回true，否则返回false
	 * @param paramString 要判断的字符串
	 * @return 判断结果布尔值
	 */
	public static boolean isEmpty (String paramString) {
		if ("".equals(paramString) || paramString == null) {
			return true;
		} else {
			return false;
		}
	}



	/**
	 * 此方法用于将Hex字符串转为byte数组
	 * @param text 要转换的字符串
	 * @return 转换后的byte数组
	 * @author Mango.
	 * @version 1.0.2
	 * @since JDK 10
	 */
	public static byte[] hex2byte(String text) {
		if (text == null) {
			return null;
		}
		int n = text.length();
		int b = 2;
		if (n % b == 1) {
			return null;
		}
		byte[] bytes = new byte[n / b];
		int n2 = 0;
		while (n2 != n / b) {
			bytes[n2] = (byte)Integer.parseInt(text.substring(n2 * 2, n2 * 2 + 2), 16);
			++n2;
		}
		return bytes;
	}

	/**
	 * 此方法为注册码编码关键方法<br>
	 *  注册码计算方式为：AES加密
	 * @param text 要加密的字符串
	 * @return 加密后的密文
	 * @throws BaseException 详细请看报错信息
	 * @throws AESException AES操作相关的异常，具体看输出
	 * @since JDK11
	 * @version 1.0.2
	 * @author qianQian.
	 */
	public  static String en(String text) {
		// 关键参数，superKey,关系着是否与tool助手兼容
		String superKey = "Format2044153997";
		boolean isEmpty = isEmpty(text);
		if (isEmpty == true) {
			return null;
		} 

		int ee = 16;

		if (superKey.length() != ee)
		{
			// 若superKey的字符不等于16，直接返回null
			return (String) null;
		}
		// 获取密钥的对象
		SecretKeySpec secretKeySpec;
		try {
			secretKeySpec = new SecretKeySpec(superKey.getBytes("ASCII"), "AES");
		} catch (UnsupportedEncodingException e1) {

			throw new BaseException(e1.getMessage());
		}
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			throw new BaseException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			throw new BaseException(e.getMessage());
		}
		try {
			cipher.init(1, secretKeySpec);
		} catch (InvalidKeyException e) {
			throw new AESException(e.getMessage());
		}
		try {
			return byte2hex(cipher.doFinal(text.getBytes())).toLowerCase();
		} catch (IllegalBlockSizeException e) {
			throw new AESException(e.getMessage());
		} catch (BadPaddingException e) {
			throw new AESException(e.getMessage());
		}
	}

	/**
	 * 此方法用于AES解密
	 * @param regcode 要解密的字符串
	 * @return 解密后的内容
	 * @throws BaseException 请查看报错信息
	 * @throws AESException AES相关异常，请查看报错信息
	 * @author qianQian.
	 * @version 1.0.2
	 * 
	 */
	public static String de(String regcode) {
		String spKey = "Format2044153997";
		if (regcode == null) {
			return (String)null; 
		}

		int o = 16;

		if (spKey.length() != o) {
			return (String)null; 
		}

		byte[] ssa;
		try {
			ssa = "Format2044153997".getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new BaseException(e.getMessage());
		}
		SecretKeySpec secretKeySpec = new SecretKeySpec(ssa, "AES");

		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw new AESException(e.getMessage());
		}
		try {
			cipher.init(2, secretKeySpec);
		} catch (InvalidKeyException e) {
			throw new AESException(e.getMessage());
		}
		byte[] arrayOfByte1 = hex2byte(regcode);

		byte[] ssa3;
		try {
			ssa3 = cipher.doFinal(arrayOfByte1);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			throw new AESException(e.getMessage());
		}
		String str = new String(ssa3);


		return str;

	}

	
	/**
	 * 私有的构造器
	 */
	private AESTool() {
		// NOOOP
		// 什么也不做
		return;
	}







}
