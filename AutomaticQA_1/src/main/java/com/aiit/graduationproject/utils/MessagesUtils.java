/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取属性文件的提示句内容
 * <p>
 * <code>Messages</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月9日 下午3:23:49
 * @since 1.0
 * @version 1.0
 */
public class MessagesUtils {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(MessagesUtils.class);

	/**
	 * properties文件名称
	 */
	private static final String properties_filename = "/properties/messages.properties";

	/**
	 * Properties map to hold the cache configuration
	 */
	private static Properties properties = null;

	/**
	 * @return the properties
	 */
	public static Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public static void setProperties(Properties properties) {
		MessagesUtils.properties = properties;
	}

	static {
		if (logger.isDebugEnabled()) {
			logger.debug("Messages Called");
		}
		properties = loadProperties(properties_filename, "the default configuration");
	}

	/**
	 * 根据key获取内容(String)
	 * <p>
	 * <code>getProperty</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		if (key == null) {
			throw new IllegalArgumentException("key is null");
		}
		if (properties == null) {
			return null;
		}
		return properties.getProperty(key);
	}

	/**
	 * 根据key获取内容(Object)
	 * <p>
	 * <code>getObjectProperty</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param key
	 * @return
	 */
	public static Object getObjectProperty(String key) {
		if (key == null) {
			throw new IllegalArgumentException("key is null");
		}
		if (properties == null) {
			return null;
		}
		return properties.getProperty(key);
	}

	/**
	 * 想属性文件中添加数据
	 * <p>
	 * <code>setProperty</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param key
	 * @param value
	 */
	public static void setProperty(Object key, Object value) {
		if (key == null) {
			throw new IllegalArgumentException("key is null");
		}
		if (value == null) {
			return;
		}
		if (properties == null) {
			properties = new Properties();
		}
		properties.put(key, value);
	}

	/**
	 * 加载属性文件messages.properties
	 * <p>
	 * <code>loadProperties</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param filename
	 * @param info
	 * @return
	 */
	public static Properties loadProperties(String filename, String info) {
		URL url = null;
		ClassLoader threadContextClassLoader = Thread.currentThread().getContextClassLoader();
		if (threadContextClassLoader != null) {
			url = threadContextClassLoader.getResource(filename);
		}
		if (url == null) {
			url = MessagesUtils.class.getResource(filename);
			if (url == null) {
				logger.warn("No properties file found in the classpath by filename " + filename);
				return new Properties();
			}
		}
		return loadProperties(url, info);
	}

	/**
	 * 根据路径获取属性文件内容
	 * <p>
	 * <code>loadProperties</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param url
	 * @param info
	 * @return
	 */
	public static Properties loadProperties(URL url, String info) {
		logger.info("Getting properties from URL " + url + " for " + info);
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = url.openStream();
			properties.load(inputStream);
			logger.info("Properties read " + properties); // 所有属性文件的内容
		} catch (IOException e) {
			logger.error("Error reading from " + url, e);
			logger.error("Ensure the properties information in " + url + " is readable and in your classpath.");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.warn("IOException while closing InputStream: " + e.getMessage());
				}
			}
		}
		return properties;
	}

	/**
	 * 该用户不存在！
	 */
	public static final String user_not_exist = "USER_NOT_EXIST";
	/**
	 * 用户名格式不对！
	 */
	public static final String user_format_error = "USER_FORMAT_ERROR";
	/**
	 * 密码格式不对！
	 */
	public static final String password_format_error = "PASSWORD_FORMAT_ERROR";
	/**
	 * 密码长度不对！
	 */
	public static final String password_length_error = "PASSWORD_LENGTH_ERROR";
	/**
	 * 密码错误！
	 */
	public static final String password_error = "PASSWORD_ERROR";
	/**
	 * 登陆成功！
	 */
	public static final String sign_in_success = "SIGN_IN_SUCCESS";

	/**
	 * 登陆失败！
	 */
	public static final String sign_in_error = "SIGN_IN_ERROR";

	/**
	 * 注册成功！
	 */
	public static final String register_success = "REGISTER_SUCCESS";

	/**
	 * 注册失败！
	 */
	public static final String register_error = "REGISTER_ERROR";

	/**
	 * 日志存储路径
	 */
	public static final String logs_path = "LOGS_PATH";

	/**
	 * 天气的基本链接
	 */
	public static final String weather_baseUrl = "WEATHER_BASEURL";

	/**
	 * 天气下载更新的天数
	 */
	public static final String full_weather_num = "Full_WEATHER_NUM";

	/**
	 * 天气的基本链接的下个节点
	 */
	public static final String weather_baseUrl_next_node = "WEATHER_BASEURL_NEXT_NODE";

	/**
	 * 获取当前位置（带IP）
	 */
	public static final String position_api_ip = "POSITION_API_IP";

	/**
	 * 获取当前位置（不带IP），默认
	 */
	public static final String position_api_not_ip = "POSITION_API_NOT_IP";

	/**
	 * 本地文件的存储位置
	 */
	public static final String pos_location_jsoup_files = "POS_LOCATION_JSOUP_FILES";

	/**
	 * 本地文件的存储位置
	 */
	public static final String web_baike_url = "WEB_BAIKE_URL";

	/**
	 * 下载文件的开始页面
	 */
	public static final String start_num = "START_NUM";

	/**
	 * 下载文件的结束页面
	 */
	public static final String end_num = "END_NUM";

	/**
	 * QA问答文件路径
	 */
	public static final String file_qa_path = "FILE_QA_PATH";

}
