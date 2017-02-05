/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>
 * <code>LocPositionUtil</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月11日 上午11:22:17
 * @since 1.0
 * @version 1.0
 */
public class LocPositionUtil {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(LocPositionUtil.class);

	/**
	 * 调用接口获取当前位置
	 * <p>
	 * <code>cityPos</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public static String cityPos() throws IOException, JSONException {
		// 这里调用百度的ip定位api服务 详见
		// http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
		String urlapi = MessagesUtils.getProperty(MessagesUtils.position_api_ip);
		// urlapi =
		// http://api.map.baidu.com/location/ip?ak=L8OlGnGfB28Ku6fpwt4KmKe39LV7QphG
		// 也是可行的
		// 117.71.53.46 合肥市的ip
		JSONObject json = readJsonFromUrl(urlapi);
		JSONObject json1 = (JSONObject) json.get("content");
		JSONObject json2 = (JSONObject) json1.get("address_detail");
		String city = (String) json2.get("city");
		return city;
	}

	/**
	 * 读取流
	 * <p>
	 * <code>readAll</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static String readAll(Reader reader) throws IOException {
		StringBuffer buffer = new StringBuffer();
		int cp = 0;
		while ((cp = reader.read()) != -1) {
			buffer.append((char) cp);
		}
		return buffer.toString();
	}

	/**
	 * 调用api获取返回值
	 * <p>
	 * <code>readJsonFromUrl</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static JSONObject readJsonFromUrl(String url) throws MalformedURLException, IOException {
		InputStream is = new URL(url).openStream();
		JSONObject json = null;
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			json = new JSONObject(jsonText);
		} catch (IOException e) {
			logger.error("IO读取出错：：", e);
			e.printStackTrace();
		} catch (JSONException e) {
			logger.error("json转化出错：：", e);
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return json;
	}
	// public static void main(String[] args) {
	// try {
	// String ss= cityPos();
	// System.out.println(ss);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (JSONException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
