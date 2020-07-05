package com.mc.film.common.utils;

import org.springframework.util.DigestUtils;

/**
 * @author Mr.Cheng
 * @since 2020/6/16
 */

public class MD5Util {

	public static String encrypt(String inputStr) {
		return DigestUtils.md5DigestAsHex(inputStr.getBytes());
	}
}
