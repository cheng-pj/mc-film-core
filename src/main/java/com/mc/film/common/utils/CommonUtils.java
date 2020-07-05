package com.mc.film.common.utils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

	/**
	 * 生成 uuid
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().toUpperCase();
	}

	public static List<String> strToList(String str) {
		String[] arrId = str.split(",");
		return Arrays.asList(arrId);
	}

	/**
	 * 手机号验证
	 */
	public static boolean isMobile(String str) {
		Pattern p = Pattern.compile("^[1][3,4,5,7,8,9][0-9]{9}$"); // 验证手机号
		Matcher m = p.matcher(str);
		return m.matches();
	}
}
