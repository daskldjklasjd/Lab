package com.bupt.vouching.util;

import java.util.UUID;

/**
 * 辅助工具类
 * 
 * @author Hogan
 * 
 */
public class Utils {

	/**
	 * 获取32位UUID的值
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 判断字符串是否为空字符串或者为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullOrBlank(Object... str) {
		for (Object e : str) {
			if (e instanceof String) {
				if (e == null || "".equals(e)) {
					return false;
				}
			} else {
				if (e == null || e == "") {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s=",s,";
		System.out.println(s.split(",").length);
	}
}
