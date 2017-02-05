/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package common.test;

/**
 * 检测正则表达式
 * <p>
 * <code>ReTest</code>
 * </p>
 *
 * @author sjwang6
 * @since 1.0
 * @version 1.0
 */
public class Regex {

	/**
	 * <p>
	 * <code>main</code>
	 * </p>
	 * 
	 * @author admin
	 * @param args
	 */
	public static void main(String[] args) {
		String email = "sjwang@iflytek.com";
		String regex = "^([A-Za-z0-9]|([a-zA-z]+[0-9]))+@+([0-9A-Za-z]+[-.])+[A-Za-z]{2,5}$"; // email正则表达式
		System.out.println(email.matches(regex));
	}

}
