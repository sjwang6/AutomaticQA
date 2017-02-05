/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aiit.graduationproject.entity.Area;
import com.aiit.graduationproject.entity.Province;
import com.aiit.graduationproject.entity.Weather;

/**
 * 获取天气信息工具
 * <p>
 * <code>WeatherUtil</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午10:14:09
 * @since 1.0
 * @version 1.0
 */
public class WeatherUtil {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(WeatherUtil.class);

	/**
	 * 获取省份名称和url,返回省份集合
	 * <p>
	 * <code>getProvinceInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param baseUrl
	 * @return
	 * @throws IOException
	 */
	public static List<Province> getProvinceInfo(String baseUrl) throws IOException {
		List<Province> provincesList = new ArrayList<Province>();
		Province province = null;
		String context = "";
		HttpURLConnection connection = (HttpURLConnection) new URL(baseUrl).openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(20000);
		connection.setReadTimeout(20000);
		if (connection.getResponseCode() == 200) {
			String con = "";
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((con = br.readLine()) != null) {
				context += con;
			}
		}
		Document doc = Jsoup.parse(context);
		Elements elements = doc.getElementsByClass("lqcontentBoxheader");
		Elements eles = elements.select("ul li a");
		for (Element element : eles) {
			province = new Province();
			String name = element.text();
			String href = element.attr("href");
			province.setProvinceName(name);
			province.setProvinceUrl(href);
			provincesList.add(province);
		}
		return provincesList;
	}

	/**
	 * 获取地区名称和url,返回地区集合
	 * <p>
	 * <code>getAreaInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param pList
	 *            省集合
	 * @return
	 * @throws IOException
	 */
	public static List<Area> getAreaInfo(List<Province> pList) throws IOException {
		List<Area> areaList = new ArrayList<Area>();
		Area area = null;
		String name = null;
		String href = null;
		for (int i = 0, size = pList.size(); i < size; i++) {
			String context = "";
			HttpURLConnection connection = (HttpURLConnection) new URL(
					MessagesUtils.getProperty(MessagesUtils.weather_baseUrl) + pList.get(i).getProvinceUrl())
							.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(20000);
			connection.setConnectTimeout(20000);
			if (connection.getResponseCode() == 200) {
				String con = "";
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((con = br.readLine()) != null) {
					context += con;
				}
			}
			Document doc = Jsoup.parse(context);
			// 获取地区
			Elements cityelements = doc.getElementsByClass("conMidtab3");
			Elements cityeles = cityelements.select("table tr td a");
			for (int j = 0, length = cityeles.size(); j < length / 7; j++) {
				if (j % 2 == 0) {
					// 获取城市的地区名称和url
					area = new Area();
					name = cityeles.get(j).text();
					href = cityeles.get(j).attr("href");
					area.setAreaName(name);
					area.setAreaUrl(href);
					areaList.add(area);
				}
			}
		}
		return areaList;
	}

	/**
	 * 根据地区获取7天的天气， 可以添加在后面
	 * <p>
	 * <code>getWeatherInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param area
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static List<Weather> getWeatherInfo(Area area) throws IOException {
		List<Weather> weathersList = new ArrayList<Weather>();
		Weather weather = null;
		String weatherWindRun = null;
		String context = "";
		logger.info("正在下载：：：" + area.getAreaId() + ":::: " + area.getAreaName() + area.getAreaUrl());
		HttpURLConnection connection = (HttpURLConnection) new URL(area.getAreaUrl()).openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(20000);
		connection.setReadTimeout(20000);
		if (connection.getResponseCode() == 200) {
			String con = "";
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((con = br.readLine()) != null) {
				context += con;
			}
		}
		Document doc = Jsoup.parse(context);
		Element element = doc.getElementById("7d");
		Elements eles = element.getElementsByClass("t").select("li");
		String[] wDate = DateUtil.enter(new Date(), 7); // 经过处理的日期,参数1是未处理的日期：参数二是看从今天之后的天数
		for (int i = 0, size = eles.size(); i < size; i++) {
			weather = new Weather();
			String weatherdate = /* eles.get(i).select("h1").text() + ";" + */wDate[i]; // 日期如：1日（今天）、2日（明天）。。。、5日（周一）
			String weatherPhenomenon = eles.get(i).getElementsByClass("wea").attr("title"); // 天气现象
																							// 如：晴天、多云
			String weatherBigTemperature = eles.get(i).getElementsByClass("tem").select("span").text(); // 最高温度
			String weatherSmallTemperature = eles.get(i).getElementsByClass("tem").select("i").text(); // 最低温度
			Elements weatherElement = eles.get(i).getElementsByClass("win").select("em").select("span"); // 风向
			// 需要判断 weatherElement的大小如果是2，则转风向，如果为1则不需
			if (weatherElement.size() == 2) {
				weatherWindRun = weatherElement.get(0).attr("title") + "\u0020转\u0020"
						+ weatherElement.get(1).attr("title");
			}
			if (weatherElement.size() == 1) {
				weatherWindRun = weatherElement.get(0).attr("title");
			}
			String weatherWind = eles.get(i).getElementsByClass("win").select("i").text(); // 风力
			// 存入数据库天气表
			weather.setWeatherDate(weatherdate);
			weather.setWeatherPhenomenon(weatherPhenomenon);
			weather.setWeatherBigTemperature(weatherBigTemperature);
			weather.setWeatherSmallTemperature(weatherSmallTemperature);
			weather.setWeatherWindRun(weatherWindRun);
			weather.setWeatherWind(weatherWind);
			weather.setFkAreaId(area.getAreaId());
			weathersList.add(weather);
		}
		return weathersList;
	}

	/**
	 * 根据地区获取7天的天气( 未使用！) error 删除第一次可以，，如果下次数据库 日期排除乱了以后 就不行了 如：20-19-18-17
	 * 降序可以，升序可以。。。20-19-16-17 error
	 * <p>
	 * <code>getWeatherInfoByList</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param areaList
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static List<Weather> getWeatherInfoByList(List<Area> areaList) throws IOException {
		List<Weather> weathersList = new ArrayList<Weather>();
		Weather weather = null;
		String weatherWindRun = null;
		String context = "";
		for (Area area : areaList) {
			logger.info("正在下载：：：" + area.getAreaId() + ":::: " + area.getAreaName() + area.getAreaUrl());
			HttpURLConnection connection = (HttpURLConnection) new URL(area.getAreaUrl()).openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(20000);
			connection.setReadTimeout(20000);
			if (connection.getResponseCode() == 200) {
				String con = "";
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((con = br.readLine()) != null) {
					context += con;
				}
			}
			Document doc = Jsoup.parse(context);
			Element element = doc.getElementById("7d");
			Elements eles = element.getElementsByClass("t").select("li");
			String[] wDate = DateUtil.enter(new Date(), 7); // 经过处理的日期,参数1是未处理的日期：参数二是看从今天之后的天数
			for (int i = 0, size = eles.size(); i < size; i++) {
				weather = new Weather();
				String weatherdate = /*
										 * eles.get(i).select("h1").text() + ";"
										 * +
										 */wDate[i]; // 日期如：1日（今天）、2日（明天）。。。、5日（周一）
				String weatherPhenomenon = eles.get(i).getElementsByClass("wea").attr("title"); // 天气现象
																								// 如：晴天、多云
				String weatherBigTemperature = eles.get(i).getElementsByClass("tem").select("span").text(); // 最高温度
				String weatherSmallTemperature = eles.get(i).getElementsByClass("tem").select("i").text(); // 最低温度
				Elements weatherElement = eles.get(i).getElementsByClass("win").select("em").select("span"); // 风向
				// 需要判断 weatherElement的大小如果是2，则转风向，如果为1则不需
				if (weatherElement.size() == 2) {
					weatherWindRun = weatherElement.get(0).attr("title") + "\u0020转\u0020"
							+ weatherElement.get(1).attr("title");
				}
				if (weatherElement.size() == 1) {
					weatherWindRun = weatherElement.get(0).attr("title");
				}
				String weatherWind = eles.get(i).getElementsByClass("win").select("i").text(); // 风力
				// 存入数据库天气表
				weather.setWeatherDate(weatherdate);
				weather.setWeatherPhenomenon(weatherPhenomenon);
				weather.setWeatherBigTemperature(weatherBigTemperature);
				weather.setWeatherSmallTemperature(weatherSmallTemperature);
				weather.setWeatherWindRun(weatherWindRun);
				weather.setWeatherWind(weatherWind);
				weather.setFkAreaId(area.getAreaId());
				weathersList.add(weather);
			}
		}
		return weathersList;
	}

	/**
	 * 根据地区获取n天的天气(1<= n <=7)
	 * <p>
	 * <code>getWeatherInfoByListAndNum</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param areaList
	 * @param num
	 *            传过来的数字
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static List<Weather> getWeatherInfoByListAndNum(Area area, int num) throws IOException {
		List<Weather> weathersList = new ArrayList<Weather>();
		Weather weather = null;
		String weatherWindRun = null;
		String context = "";
		logger.info("正在下载：：：" + area.getAreaId() + ":::: " + area.getAreaName() + area.getAreaUrl());
		HttpURLConnection connection = (HttpURLConnection) new URL(area.getAreaUrl()).openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(20000);
		connection.setReadTimeout(20000);
		if (connection.getResponseCode() == 200) {
			String con = "";
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((con = br.readLine()) != null) {
				context += con;
			}
		}
		Document doc = Jsoup.parse(context);
		Element element = doc.getElementById("7d");
		Elements eles = element.getElementsByClass("t").select("li");
		String[] wDate = DateUtil.enter(new Date(), 7); // 经过处理的日期,参数1是未处理的日期：参数二是看从今天之后的天数
		for (int i = 0, size = eles.size(); i < num; i++) {
			weather = new Weather();
			/* eles.get(size-1-i).select("h1").text() + ";"+ */
			String weatherdate = wDate[size - 1 - i]; // 日期如：1日（今天）、2日（明天）。。。、5日（周一）
			String weatherPhenomenon = eles.get(size - 1 - i).getElementsByClass("wea").attr("title"); // 天气现象
																										// 如：晴天、多云
			String weatherBigTemperature = eles.get(size - 1 - i).getElementsByClass("tem").select("span").text(); // 最高温度
			String weatherSmallTemperature = eles.get(size - 1 - i).getElementsByClass("tem").select("i").text(); // 最低温度
			Elements weatherElement = eles.get(size - 1 - i).getElementsByClass("win").select("em").select("span"); // 风向
			// 需要判断 weatherElement的大小如果是2，则转风向，如果为1则不需
			if (weatherElement.size() == 2) {
				weatherWindRun = weatherElement.get(0).attr("title") + "\u0020转\u0020"
						+ weatherElement.get(1).attr("title");
			}
			if (weatherElement.size() == 1) {
				weatherWindRun = weatherElement.get(0).attr("title");
			}
			String weatherWind = eles.get(size - 1 - i).getElementsByClass("win").select("i").text(); // 风力
			// 存入数据库时间排序是顺序天气表
			// weather.setWeatherId(7 * (area.getAreaId() - 1) + i + 1); //
			// 数据库时间排序是倒序时的id添加办法
			weather.setWeatherId(7 * area.getAreaId() - i);
			weather.setWeatherDate(weatherdate);
			weather.setWeatherPhenomenon(weatherPhenomenon);
			weather.setWeatherBigTemperature(weatherBigTemperature);
			weather.setWeatherSmallTemperature(weatherSmallTemperature);
			weather.setWeatherWindRun(weatherWindRun);
			weather.setWeatherWind(weatherWind);
			weather.setFkAreaId(area.getAreaId());
			weathersList.add(weather);
		}
		return weathersList;
	}
}
