/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

/**
 * String类型数据工具类
 * <p>
 * <code>StringUtils</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月27日 上午10:20:18
 * @since 1.0
 * @version 1.0
 */
public class StringUtils {

	/**
	 * 判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
	 * <p>
	 * <code>isEmpty</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param str
	 * @return 空为true，非空为false
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.length() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否非空，等同于!isEmpty(str);
	 * <p>
	 * <code>isNotEmpty</code>
	 * </p>
	 * 
	 * @author admin
	 * @param str
	 * @return 非空为true，空为false
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 杀空函数，将"null"和null对象转换为""
	 * <p>
	 * <code>killNull</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param str
	 * @return returnStr
	 */
	public static String killNull(String str) {
		String returnStr = null;
		if (str == null || "null".equals(str.toUpperCase())) {
			returnStr = "";
		} else {
			returnStr = str;
		}
		return returnStr;
	}

	/**
	 * 将String转化为Integer
	 * <p>
	 * <code>StringCastInteger</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param key
	 * @return
	 */
	public static int StringCastInteger(String key) {
		int key1 = 0;
		if (StringUtils.isNotEmpty(key)) {
			key1 = new Integer(key);
		}

		return key1;
	}

}
